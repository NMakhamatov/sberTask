package ru.tsc.sberTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import ru.tsc.sberTask.dao.Finder;
import ru.tsc.sberTask.model.Member;
import ru.tsc.sberTask.model.MembersGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
//@PropertySource({"classpath:application.yml"})
public class SberTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(SberTaskApplication.class, args);
	}
}
