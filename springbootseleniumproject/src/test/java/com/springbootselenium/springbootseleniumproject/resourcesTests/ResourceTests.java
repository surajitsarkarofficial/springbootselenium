package com.springbootselenium.springbootseleniumproject.resourcesTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ResourceTests extends SpringBaseTestNGTests {

    //When file is present with in project
    @Value("classpath:data/testdata.csv")
    Resource resourceInsideProject;

    //When file si present outside project but in local disk
    @Value("file:C:\\Learning\\Springboot\\springbootselenium\\springbootseleniumproject\\src\\test\\resources\\data\\testdata.csv")
    Resource resourceOutsideProject;

    //When file is in external url
    @Value("http://www.w3.org/TR/PNG/iso_8859-1.txt")
    Resource resourceFromExternalURL;

    @Value("${screenshot.path}/sometext.txt")
    private Path path;

    /**
     * This code will read the file present with in project
     * @throws IOException
     */
    @Test
    public void readTestDataWithInProject() throws IOException {
        List<String> fileLines = Files.readAllLines(resourceInsideProject.getFile().toPath());

        for(String line : fileLines)
        {
            System.out.println(line);
        }
    }

    /**
     * This code will read file present in local disk outside project
     * @throws IOException
     */
    @Test
    public void readTestDataOutsideProject() throws IOException {
        List<String> fileLines = Files.readAllLines(resourceOutsideProject.getFile().toPath());

        for(String line : fileLines)
        {
            System.out.println(line);
        }
    }

    /**
     * This code will read file from external url
     * @throws IOException
     */
    @Test
    public void readTestDataFromExternalURL() throws IOException {
        System.out.println(
                new String(resourceFromExternalURL.getInputStream().readAllBytes())
        );
    }

    /**
     * This code will download the file from external url
     * @throws IOException
     */
    @Test
    public void downloadTestDataFromExternalURL() throws IOException {
        FileCopyUtils.copy(resourceFromExternalURL.getInputStream(),
                Files.newOutputStream(path));
    }

}
