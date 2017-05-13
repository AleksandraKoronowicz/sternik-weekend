package projectapp.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import projectapp.entities.Moneta;
import projectapp.entities.Status;


@Repository
@Qualifier("tablica")
public class ProstaBazaDanych implements MonetyRepository {

    private Moneta[] baza;

    public ProstaBazaDanych() {
    	baza = new Moneta[15];
        Moneta m = new Moneta();
        m.setNumerPorzadkowy(0L);
        m.setDodatkoweInformacje("Additional..");
        m.setPriorytet(0L);
        m.setMiejsceWykonania("w domu");
        m.setoOisZadania("Umyj lodówke");
        m.setDataRealizacji(new Date());
        m.setCzasRealizacji(new BigDecimal("1.2"));
        m.setStatus(Status.DO_ZROBIENIA);
        baza[0] = m;
        m = new Moneta();
        m.setNumerPorzadkowy(0L);
        m.setDodatkoweInformacje("Additional..");
        m.setPriorytet(0L);
        m.setMiejsceWykonania("w domu");
        m.setoOisZadania("Umyj lodówke");
        m.setDataRealizacji(new Date());
        m.setCzasRealizacji(new BigDecimal("1.2"));
        m.setStatus(Status.ANULOWANE);
        baza[2] = m;

    }

    public ProstaBazaDanych(int rozmiarBazy) {
        baza = new Moneta[rozmiarBazy];
    }

    @Override
    public Moneta create(Moneta moneta) throws MonetaAlreadyExistsException {
        if (moneta.getNumerPorzadkowy() != null && baza[moneta.getNumerPorzadkowy().intValue()] != null) {
            if (moneta.getNumerPorzadkowy().equals(baza[moneta.getNumerPorzadkowy().intValue()].getNumerPorzadkowy())) {
                throw new MonetaAlreadyExistsException("Już jest moneta o takim numerze.");
            }
        }
        for (int i = 0; i < baza.length; i++) {
            if (baza[i] == null) {
                baza[i] = moneta;
                moneta.setNumerPorzadkowy((long) i);
                return moneta;
            }
        }
        throw new RuntimeException("Brak miejsca w tablicy");
    }

    @Override
    public void deleteById(Long id) throws NoSuchMonetaException {
        int numerKatalogowy = id.intValue();
        if (!sprawdzPoprawnoscNumeruKatalogowego(numerKatalogowy)) {
            throw new NoSuchMonetaException("Nie poprawny numer katologowy");
        }
        // tu troche zle ;)
        baza[numerKatalogowy] = null;
    }

    @Override
    public Moneta update(Moneta moneta) throws NoSuchMonetaException {
        int numerKatalogowy = moneta.getNumerPorzadkowy().intValue();
        if (!sprawdzPoprawnoscNumeruKatalogowego(numerKatalogowy)) {
            throw new NoSuchMonetaException("Nie poprawny numer katologowy");
        }

        Moneta m = baza[moneta.getNumerPorzadkowy().intValue()];
        if (m == null) {
            throw new NoSuchMonetaException("Brak takiej monety.");
        } else {
            baza[moneta.getNumerPorzadkowy().intValue()] = moneta;
        }
        return moneta;
    }

    @Override
    public Moneta readById(Long numerKatalogowy) throws NoSuchMonetaException {
        int id = numerKatalogowy.intValue();
        if (!sprawdzPoprawnoscNumeruKatalogowego(id) || czyWolne(id)) {
            throw new NoSuchMonetaException();
        }
        return baza[id];
    }

    private boolean czyWolne(int id) {
        if(baza[id]!= null)
            return false;
        return true;
    }

    @Override
    public List<Moneta> findAll() {
        List<Moneta> tmp = new ArrayList<>();
        for (int i = 0; i < baza.length; i++) {
            if (baza[i] != null)
                tmp.add(baza[i]);
        }
        return tmp;
    }

    public void wyswietlBaze() {
        for (int i = 0; i < baza.length; i++) {
            System.out.println("" + i + ":" + baza[i]);
        }
    }

    private boolean sprawdzPoprawnoscNumeruKatalogowego(int numerKatalogowy) {
        if (numerKatalogowy < 0 || numerKatalogowy >= baza.length) {
            System.out.println("Zły numer katalogowy");
            return false;
        }
        return true;
    }

}