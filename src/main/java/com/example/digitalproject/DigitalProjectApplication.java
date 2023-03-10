package com.example.digitalproject;

import com.example.digitalproject.models.dto.answers.AnswerPostDTO;
import com.example.digitalproject.models.dto.documents.DocumentPostDTO;
import com.example.digitalproject.models.dto.grades.GradePostDTO;
import com.example.digitalproject.models.dto.jobs.JobPostDTO;
import com.example.digitalproject.models.dto.persons.PersonPostDTO;
import com.example.digitalproject.models.dto.subjects.SubjectPostDTO;
import com.example.digitalproject.models.dto.tasks.TaskPostDTO;
import com.example.digitalproject.services.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Digital API", version = "1337.228", description = "Educational platform"))
@SecurityScheme(name = "digital-project", scheme = "bearer", type = SecuritySchemeType.HTTP, bearerFormat = "JWT")
public class DigitalProjectApplication implements CommandLineRunner {
    @Autowired
    private PersonService personService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private JobService jobService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private GradeService gradeService;

    public static void main(String[] args) {
        SpringApplication.run(DigitalProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jobService.postEntity(new JobPostDTO("??????????????", 60_000L, List.of("??????????", "??????????????")));
        jobService.postEntity(new JobPostDTO("??????????????", 20_000L, List.of("??????????????", "???????????????????? ??????????")));

        personService.postEntity(new PersonPostDTO("????????", "????????????", "88005553535", "???? ?????? ??????"), 1L);
        personService.postEntity(new PersonPostDTO("????????", "????????????", "342567", "??????????"), 2L);
        personService.postEntity(new PersonPostDTO("????????????", "????????????", "?????????? ??????????", "??????"), 2L);

        documentService.postEntity(new DocumentPostDTO("??????????????", "??????-????"), 1L);
        documentService.postEntity(new DocumentPostDTO("??????????????", "??????-????"), 2L);
        documentService.postEntity(new DocumentPostDTO("??????????????", "??????-????"), 3L);
        documentService.postEntity(new DocumentPostDTO("???????????????????? ??????????", "????????"), 3L);

        subjectService.postEntity(new SubjectPostDTO("????????????"));
        subjectService.postEntity(new SubjectPostDTO("??????????"));
        subjectService.postEntity(new SubjectPostDTO("????????????"));
        subjectService.postEntity(new SubjectPostDTO("??????????"));

        personService.addSubjectsToPerson(1L, 1L);
        personService.addSubjectsToPerson(1L, 2L);
        personService.addSubjectsToPerson(1L, 3L);

        personService.addSubjectsToPerson(2L, 1L);
        personService.addSubjectsToPerson(2L, 4L);

        personService.addSubjectsToPerson(3L, 1L);
        personService.addSubjectsToPerson(3L, 2L);
        personService.addSubjectsToPerson(3L, 3L);
        personService.addSubjectsToPerson(3L, 4L);

        taskService.postEntity(new TaskPostDTO("???????????? 1-5", LocalDate.now(), LocalDate.now().plusDays(7)), 1L);
        taskService.postEntity(new TaskPostDTO("???????? 1", LocalDate.now(), LocalDate.now().plusDays(7)), 2L);
        taskService.postEntity(new TaskPostDTO("???????????? 1-123", LocalDate.now(), LocalDate.now().plusDays(7)), 3L);
        taskService.postEntity(new TaskPostDTO("???????????????? ????????????", LocalDate.now(), LocalDate.now().plusDays(7)), 3L);
        taskService.postEntity(new TaskPostDTO("10000 ??????????????????", LocalDate.now(), LocalDate.now().plusDays(7)), 4L);

        answerService.postEntity(new AnswerPostDTO(LocalDate.now(), "?? ???? ????????????"), 1L, 1L);
        answerService.postEntity(new AnswerPostDTO(LocalDate.now(), "??????"), 1L, 3L);
        answerService.postEntity(new AnswerPostDTO(LocalDate.now(), "?????????? 40 ????"), 2L, 5L);
        answerService.postEntity(new AnswerPostDTO(LocalDate.now(), "?? ??????????????????"), 3L, 4L);
        answerService.postEntity(new AnswerPostDTO(LocalDate.now(), "?? ????????????"), 3L, 2L);

        gradeService.postEntity(new GradePostDTO("??????", "????"), 1L);
        gradeService.postEntity(new GradePostDTO("??????????????", "?????????????? ??????????"), 2L);
        gradeService.postEntity(new GradePostDTO("??????????????", "??????"), 3L);
        gradeService.postEntity(new GradePostDTO("???? ??????????", "???? ??????????"), 4L);
        gradeService.postEntity(new GradePostDTO("??????", "??????"), 5L);
    }
}
