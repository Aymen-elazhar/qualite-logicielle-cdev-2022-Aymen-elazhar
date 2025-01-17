package com.ipiecoles.java.java350.model.model;

import com.ipiecoles.java.java350.model.Employe;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

public class employeTest {
    @Test
    public void testGetNombreAnneeAnciennete(){
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(2));

        Assertions.assertThat(2).isEqualTo(employe.getNombreAnneeAnciennete());
    }

    @Test
    public void testGetNombreAnneeAncienneteNull(){
        Employe employe = new Employe();

        Assertions.assertThat(0).isEqualTo(employe.getNombreAnneeAnciennete());

    }

    @Test
    public void testGetNombreAnneeAncienneteFuture(){
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().plusYears(2));

        Assertions.assertThat(0).isEqualTo(employe.getNombreAnneeAnciennete());

    }

    @Test
    public void testGetNombreAnneeAnciennetePassee(){
        Employe employe = new Employe();
        employe.setDateEmbauche(LocalDate.now().minusYears(2));

        Assertions.assertThat(2).isEqualTo(employe.getNombreAnneeAnciennete());

    }

    @ParameterizedTest
    @CsvSource({
            "'M12345',0,1,1.0,1700.0",
            "'M12345',0,0,1.0,1700.0",
            "'M12345',0,2,1.0,1700.0",
            "'T12345',0,1,1.0,1000.0",
            "'T12345',0,0,1.0,300.0",
            "'0',0,0,1.0,300.0",
    })
    public void testGetPrimeAnnuelle(String matricule,
                                     Integer nbAnneesAnciennete,
                                     Integer performance,
                                     Double tauxTravail,
                                     Double primeCalculee){
        //Given
        Employe employe = new Employe("Doe", "John", matricule, LocalDate.now().minusYears(nbAnneesAnciennete),
                2500d, performance, tauxTravail);
        //When
        Double prime = employe.getPrimeAnnuelle();
        //Then
        Assertions.assertThat(prime).isEqualTo(primeCalculee);
    }
}