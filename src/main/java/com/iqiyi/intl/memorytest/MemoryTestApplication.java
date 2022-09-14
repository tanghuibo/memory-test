package com.iqiyi.intl.memorytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class MemoryTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemoryTestApplication.class, args);
	}

	List<byte[]> list = new ArrayList<>();

	@GetMapping("check")
	public String check() {
		return "ok";
	}

	@GetMapping("add")
	public String add(@RequestParam("size") Integer size) {
		list.add(new byte[size]);
		return "success";
	}



	@GetMapping("clear")
	public String clear() {
		list.clear();
		return "success";
	}

	@GetMapping("gc")
	public String gc() {
		System.gc();
		System.runFinalization();
		return "success";
	}

}
