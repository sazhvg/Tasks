package com.ua.sazhyn.volodymyr.springtask.jsoncontroller;

import com.ua.sazhyn.volodymyr.springtask.repository.Data;
import com.ua.sazhyn.volodymyr.springtask.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public void getProjects() {
        Data.getData().stream().filter((p) -> p.getProject() != null).forEach(p -> System.out.println(p.getProject()));
    }

//failed-results – поверне список з результатами які не “success”
    @GetMapping("/failed-results")
    public void getFailedResults() {
        Data.getData().stream().filter((p) -> !p.getResult().equals("success")).forEach(p -> System.out.println(p.getProject()));
    }

//long-compilation – поверне список з об’єктами в яких compilationTime >= 1000
    @GetMapping("/long-compilation")
    public void getLongCompilation() {
        Data.getData().stream().filter((p) -> p.getCompilationTime() >= 1000).forEach(p -> System.out.println(p.getProject()));
    }

//normal -compilation – поверне список з об’єктами в яких compilationTime < 1000
    @GetMapping("/normal -compilation")
    public void getNormalCompilation() {
        Data.getData().stream().filter((p) -> p.getCompilationTime() < 1000).forEach(p -> System.out.println(p.getProject()));
    }

//success-result - – поверне список з результатами які “success”
    @GetMapping("/success-result")
    public void getSuccessResults() {
        Data.getData().stream().filter((p) -> p.getResult().equals("success")).forEach(p -> System.out.println(p.getProject()));
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
