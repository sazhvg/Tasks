package com.ua.sazhyn.volodymyr.springtask.jsoncontroller;

import com.ua.sazhyn.volodymyr.springtask.repository.Data;
import com.ua.sazhyn.volodymyr.springtask.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    private JsonService jsonService;

    @PutMapping("/register-compilation-time")
    public void register(@RequestBody Data data) {
        jsonService.register(data);
    }

//projects – поверне список з назвами проектів які були збережені до цього
    @GetMapping("/projects")
    public Set<Data> getProjects() {
        Set<Data> data = new HashSet<>();
//        Data.getData().stream().filter((p) -> p.getProject() != null).forEach(p -> System.out.println(p.getProject()));
        data = Data.getData().stream().filter((p) -> p.getProject() != null).collect(Collectors.toSet());
        return data;
    }

//failed-results – поверне список з результатами які не “success”
    @GetMapping("/failed-results")
    public Set<Data> getFailedResults() {
        Set<Data> data = new HashSet<>();
//        Data.getData().stream().filter((p) -> !p.getResult().equals("success")).forEach(p -> System.out.println(p.getProject()));
        data = Data.getData().stream().filter((p) -> !p.getResult().equals("success")).collect(Collectors.toSet());
        return data;
    }

//long-compilation – поверне список з об’єктами в яких compilationTime >= 1000
    @GetMapping("/long-compilation")
    public Set<Data> getLongCompilation() {
        Set<Data> data = new HashSet<>();
//        Data.getData().stream().filter((p) -> p.getCompilationTime() >= 1000).forEach(p -> System.out.println(p.getProject()));
        data = Data.getData().stream().filter((p) -> p.getCompilationTime() >= 1000).collect(Collectors.toSet());
        return data;
    }

//normal -compilation – поверне список з об’єктами в яких compilationTime < 1000
    @GetMapping("/normal -compilation")
    public Set<Data> getNormalCompilation() {
        Set<Data> data = new HashSet<>();
//        Data.getData().stream().filter((p) -> p.getCompilationTime() < 1000).forEach(p -> System.out.println(p.getProject()));
        data = Data.getData().stream().filter((p) -> p.getCompilationTime() < 1000).collect(Collectors.toSet());
        return data;
    }

//success-result - – поверне список з результатами які “success”
    @GetMapping("/success-result")
    public Set<Data> getSuccessResults() {
        Set<Data> data = new HashSet<>();
//        Data.getData().stream().filter((p) -> p.getResult().equals("success")).forEach(p -> System.out.println(p.getProject()));
        data = Data.getData().stream().filter((p) -> p.getResult().equals("success")).collect(Collectors.toSet());
        return data;
    }
}
/*	Створи простий веб-сервіс, який приймає json (за допомогою Postman) такого вигляду:

		Запит: /register-compilation-time
		{
		"project": "privat24",
		"timestamp": "2022-01-22 22:49:52",
		"compilationTime": "673",
		"result": "success"
		}
		, зберігає ці данні в програмі.

		Завдання 3
		Напиши додаткові запити для отримання окремої інофрмації до прикладу:

		/projects – поверне список з назвами проектів які були збережені до цього
		/failed-results – поверне список з результатами які не “success”
		/long-compilation – поверне список з об’єктами в яких compilationTime >= 1000
		/normal -compilation – поверне список з об’єктами в яких compilationTime < 1000
		/success-result - – поверне список з результатами які “success”*/
