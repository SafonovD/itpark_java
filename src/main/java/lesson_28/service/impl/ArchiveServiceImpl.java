package lesson_28.service.impl;


import lesson_28.service.ArchiveService;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    private static final String ZIP = ".zip";

    @Override
    public Optional<String> zip(String source){
        final File file = new File(source);
        final String newZipFile = FilenameUtils.removeExtension(source) + ZIP;
        try (final ZipFile zipFile = new ZipFile(file.getParent() + File.separator + FilenameUtils.getName(newZipFile))){
            if (file.isFile()){
                zipFile.addFile(source);
            }else{
                zipFile.addFolder(file);
            }

        }catch (IOException io){
            System.out.printf("Не удалось заархивировать файл %s", source);
            return Optional.empty();
        }
        return Optional.of(newZipFile);
    }

    @Override
    public Optional<String> unzip(String source, String password) {
        final ZipFile zipFile = new ZipFile(source);
        if(StringUtils.isNotBlank(password)){
            zipFile.setPassword(password.toCharArray());
        }
        final String parent = new File(source).getParent();
        try{
            zipFile.extractAll(parent);
        }catch (ZipException zipException){
            System.out.printf("Не удалось разархивировать файл %s", source);
        }
        return Optional.of(parent);
    }
}
