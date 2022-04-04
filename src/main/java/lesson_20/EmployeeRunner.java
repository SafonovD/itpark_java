package lesson_20;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson_20.dto.*;
import lombok.SneakyThrows;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXB;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class EmployeeRunner {
    private static final List<Department> DEPARTMENTS = List.of(
            new Department("IT", "Kazan"),
            new Department("Marketing", "Kazan"),
            new Department("Account", "Kazan"));

    private static final List<Position> POSITIONS = List.of(
            new Position("Director", new BigDecimal(8000)),
            new Position("IT Director", new BigDecimal(5000)),
            new Position("Marketolog", new BigDecimal(800)),
            new Position("Developer", new BigDecimal(3000)),
            new Position("Team Leader", new BigDecimal(4000)));


    private static int COUNTER = 1;

   private static final TypeReference<EmployeeList> TR = new TypeReference<>() {};

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Запуск программы");

        EmployeeList employees = new EmployeeList(List.of(
                getEmployee("Иванов Иван Иванович"),
                getEmployee("Петров Сергей Сергеевич"),
                getEmployee("Сидоров Максим Петрович"),
                getEmployee("Петров Сергей Максимович")
        ));
        Path path = Paths.get("C:\\test\\employees.xml");

        Path pathParent = path.getParent();
        System.out.printf("Создание директории для файла %s\n", pathParent);
        if (!pathParent.toFile().exists()) {
            pathParent.toFile().mkdirs();
        }
        System.out.printf("Создание файла %s\n", path.getFileName());
        JAXB.marshal(employees, path.toFile());
        Document document = getDocument(path.toFile());
        Integer avgSalary = getAvgSalary(document);
        System.out.printf("Поиск всех сотрудников зарплата который выше среднего %d\n", avgSalary);
        List<String> employeeList = searchEmployeesWithMoreAverageSalary(document, avgSalary);
        System.out.println(employeeList);
        String json = XML.toJSONObject(String.join("", Files.readAllLines(path))).toString();
        Path jsonPath = pathParent.resolve("employee.json");
        System.out.printf("Создание файла %s\n", jsonPath.getFileName());
        Files.writeString(jsonPath, json, StandardOpenOption.WRITE);
        System.out.println("Ищем и выводим всех сотрудников на нечетной позиции");
        List<Employee> oddEmploee = getOddEmployees(jsonPath);
        System.out.println(oddEmploee);
    }

    private static List<Employee> getOddEmployees(Path jsonPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        EmployeeList employeesFromJson = objectMapper.readValue(jsonPath.toFile(), TR);
        List<Employee> oddEmploee = employeesFromJson.getEmployees().stream().filter(employee -> employeesFromJson.getEmployees().indexOf(employee) % 2 == 1).collect(Collectors.toList());
        return oddEmploee;
    }

    private static Employee getEmployee(String fullName) {
        return new Employee().setLogin("User" + COUNTER++)
                .setFullName(fullName)
                .setTabNumber(new Random().nextInt(100_000) + "")
                .setDepartment(DEPARTMENTS.get(new Random().nextInt(DEPARTMENTS.size())))
                .setPosition(POSITIONS.get(new Random().nextInt(POSITIONS.size())));
    }

    @SneakyThrows
    private static List<String> searchEmployeesWithMoreAverageSalary(Document doc, int salary) {

        XPathFactory xPathFactory = XPathFactory.newInstance();
        NodeList nodeList = (NodeList) xPathFactory.newXPath().compile("//employee/position[@salary > " + salary + "]/ancestor::employee/fullName/text()").evaluate(doc, XPathConstants.NODESET);
        List<String> result = new ArrayList();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
                    result.add(item.getNodeValue());
                }
        return result;
    }


    @SneakyThrows
    private static Integer getAvgSalary(Document doc) {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        Double result = (Double) xPathFactory.newXPath().compile("sum(//position/@salary) div count(//position)").evaluate(doc, XPathConstants.NUMBER);
        return result != null ? result.intValue() : 0;
    }


    @SneakyThrows
    private static Document getDocument(File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        return documentBuilder.parse(file);
    }
}
