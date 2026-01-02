package com.cdigital.tu_cv_sprint_boot.tuCV.service;

import com.cdigital.tu_cv_sprint_boot.tuCV.model.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service // Aqui se maneja la capa de negocios
public class CvInitializationServiceImpl implements CvInitializationService{

    @Override
    public CvData initialiceCvData() {

        CvData cvData = new CvData();

        //Datos personales
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setFirstName("Francis");
        personalDetails.setLastName("Figuereo");
        personalDetails.setEmail("fgocam@gmail.com");
        personalDetails.setProfessionalProfile("Desarrollador Backend");
        cvData.setPersonalDetails(personalDetails);

        //Education
        Education education1 = new Education();
        education1.setInstitution("University of Example");
        education1.setDescription("Description");
        education1.setDegree("Bachelor of Science in Computer Science");
        education1.setPeriod("2010 - 2014");
        cvData.setEducations(Collections.singletonList(education1)); // recibe una sola lista

        //Experience
        Experience experience1 = new Experience();
        experience1.setJobTitle("CEO");
        experience1.setCompany("Cosmos Digital SRL.");
        experience1.setPeriod("2020 - Actualidad");

        Experience experience2 = new Experience();
        experience2.setJobTitle("Senior Developer");
        experience2.setCompany("DevTalles Corp.");
        experience2.setPeriod("2016 - 2020");

        cvData.setExperiences(List.of(experience1, experience2));

        // Nota: una vez creada un lista no se puede alterar, son immutable
        List<String> lista = List.of("A","B","C");
        lista.get(0); // Ok.
        //lista.add("D"); // Error en tiempo de ejecución

        //Habilidades - Skills
        Skill skill1 = new Skill();
        skill1.setName("Java");
        skill1.setLevel("Advanced");

        Skill skill2 = new Skill();
        skill2.setName("Sprint Framework");
        skill2.setLevel("Advanced");

        cvData.setSkills(Arrays.asList(skill1,skill2));

        //Nota: un Array list permite modificar contenido, no el tamaño, no agregar elementos
        List<String> lista1 = Arrays.asList("A","B","C");
        lista1.set(0,"Z"); // Ok.
       // lista1.add("F"); // Error en tiempo de ejecucion.

        return cvData;
    }
}
