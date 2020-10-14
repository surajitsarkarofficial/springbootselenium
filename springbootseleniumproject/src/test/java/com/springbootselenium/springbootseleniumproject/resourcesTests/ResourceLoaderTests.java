package com.springbootselenium.springbootseleniumproject.resourcesTests;

import com.springbootselenium.springbootseleniumproject.SpringBaseTestNGTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ResourceLoaderTests extends SpringBaseTestNGTests {

    @Autowired
    ResourceLoader loader;

    @Value("classpath:data/urls")
    Resource resource;

    @Test
    public void loadResources() throws IOException {
        List<String> urls =Files.readAllLines(resource.getFile().toPath());

        System.out.println(new String(loader.getResource(urls.get(0)).getInputStream().readAllBytes()));

        System.out.println(new String(loader.getResource(urls.get(1)).getInputStream().readAllBytes()));
    }
}
