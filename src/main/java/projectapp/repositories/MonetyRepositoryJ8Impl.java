package projectapp.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import projectapp.entities.Moneta;
import projectapp.entities.Status;


@Service
@Qualifier("lista")
public class MonetyRepositoryJ8Impl implements MonetyRepository {

    private List<Moneta> monety = new ArrayList<Moneta>() {
        {
        	  add(Moneta.produceMoneta(1L, "Wysłać maila z życzeniami", 1L, "w domu", "Mail z DW do Edka i Janka", new Date(), new BigDecimal("1.2"),
                      Status.ANULOWANE));
              add(Moneta.produceMoneta(2L, "Zadzwonić do cioci", 1L, "w drodze do szkoły", "Ciocia Ewa ma ur", new Date(), new BigDecimal("1.2"),
                      Status.DO_ZROBIENIA));
              add(Moneta.produceMoneta(3L, "Kupić prezent na dzień mamy", 1L, "Galeria H", "Kosmetyki", new Date(), new BigDecimal("1.2"), Status.NEW));
              add(Moneta.produceMoneta(4L, "Pisz magisterkę!!", 1L, "w domu", "dokończyć rozdział II", new Date(), new BigDecimal("1.2"),
                      Status.NEW));
              add(Moneta.produceMoneta(5L, "Rachunki na media", 1L, "w domu", "58,90 zł", new Date(), new BigDecimal("1.2"), Status.ANULOWANE));
              add(Moneta.produceMoneta(6L, "Siłownia", 1L, "CH Katowice", "zajęcia cross", new Date(), new BigDecimal("1.2"), Status.NEW));        }
    };

    @Override
    public List<Moneta> findAll() {
        return this.monety;
    }

    @Override
    public Moneta readById(Long id) throws NoSuchMonetaException {
        return this.monety.stream().filter(p -> Objects.equals(p.getNumerPorzadkowy(), id)).findFirst()
                .orElseThrow(NoSuchMonetaException::new);
    }

    @Override
    public Moneta create(Moneta moneta) {
        if (!monety.isEmpty()) {
            moneta.setNumerPorzadkowy(
                    this.monety.stream().mapToLong(p -> p.getNumerPorzadkowy()).max().getAsLong() + 1);
        } else {
            moneta.setNumerPorzadkowy(1L);
        }
        this.monety.add(moneta);
        return moneta;
    }

    @Override
    public Moneta update(Moneta moneta) throws NoSuchMonetaException {
        for (int i = 0; i < this.monety.size(); i++) {
            if (Objects.equals(this.monety.get(i).getNumerPorzadkowy(), moneta.getNumerPorzadkowy())) {
                this.monety.set(i, moneta);
                return moneta;
            }
        }
        throw new NoSuchMonetaException("Nie ma takiego zadania: " + moneta.getNumerPorzadkowy());
    }

    @Override
    public void deleteById(Long id) throws NoSuchMonetaException {
        for (int i = 0; i < this.monety.size(); i++) {
            if (Objects.equals(this.monety.get(i).getNumerPorzadkowy(), id)) {
                this.monety.remove(i);
            }
        }
        throw new NoSuchMonetaException("Nie ma takiej Monety: " + id);
    }

}