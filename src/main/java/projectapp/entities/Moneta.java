package projectapp.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//@Entity
//@XmlRootElement
public class Moneta {

//    @NotNull
//    @Id
    private Long numerKatalogowy;
	
//	@NotNull
	private Long priorytet;
	
	//@Size(min=2, max=30, message = "{Size.moneta.opis}")
//	@Size(min=2, max=30, message = "Opis should be in the range [{min}...{max}]")
	private String opisZadania;
//	@NotEmpty
	private String szczegoly;
//	@NotNull
	private String czasWykonania;
//	@NotNull
	private Date dataWykonania;
//	@NotEmpty
	private String miejsceWykonania;
//	@NotNull
	private Status status;

	
	
	public static Moneta produceMoneta(Long numerKatalogowy, 
			String miejsceWykonania, 
			Long priorytet, 
			String szczegoly, String opisZadania,
			Date dataWykonania, String czasWykonania, Status status) {
		Moneta m = new Moneta();
		m.numerKatalogowy = numerKatalogowy;
		m.czasWykonania = czasWykonania;
		m.miejsceWykonania = miejsceWykonania;
		m.opisZadania = opisZadania;
		m.dataWykonania = dataWykonania;
		m.priorytet = priorytet;
		m.szczegoly = szczegoly;
		m.status = status;
		return m;
	}

	public Long getNumerKatalogowy() {
		return numerKatalogowy;
	}

	public String getMiejsceWykonania() {
		return miejsceWykonania;
	}

	public Long getPriorytet() {
		return priorytet;
	}

	public String getSzczegoly() {
		return szczegoly;
	}

	public String getOpisZadania() {
		return opisZadania;
	}

	public Date getDataWykonania() {
		return dataWykonania;
	}

	public String getCzasWykonania() {
		return czasWykonania;
	}

	public Status getStatus() {
		return status;
	}

	public void setNumerKatalogowy(Long numerKatalogowy) {
		this.numerKatalogowy = numerKatalogowy;
	}

	public void setMiejsceWykonania(String miejsceWykonania) {
		this.miejsceWykonania = miejsceWykonania;
	}

	public void setProrytet(Long priorytet) {
		this.priorytet = priorytet;
	}

	public void setSzczegoly(String szczegóły) {
		this.szczegoly = szczegóły;
	}

	public void setOpisZadania(String opisZadania) {
		this.opisZadania = opisZadania;
	}

	public void setDataWykonania(Date dataWykonania) {
		this.dataWykonania = dataWykonania;
	}

	public void setCzasWykonania(String czasWykonania) {
		this.czasWykonania = czasWykonania;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opisZadania == null) ? 0 : opisZadania.hashCode());
		result = prime * result + ((miejsceWykonania == null) ? 0 : miejsceWykonania.hashCode());
		result = prime * result + ((priorytet == null) ? 0 : priorytet.hashCode());
		result = prime * result + ((szczegoly == null) ? 0 : szczegoly.hashCode());
		result = prime * result + ((opisZadania == null) ? 0 : opisZadania.hashCode());
		result = prime * result + ((dataWykonania == null) ? 0 : dataWykonania.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((czasWykonania == null) ? 0 : czasWykonania.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moneta other = (Moneta) obj;
		if (miejsceWykonania == null) {
			if (other.miejsceWykonania != null)
				return false;
		} else if (!miejsceWykonania.equals(other.miejsceWykonania))
			return false;
		if (priorytet == null) {
			if (other.priorytet != null)
				return false;
		} else if (!priorytet.equals(other.priorytet))
			return false;
		if (szczegoly == null) {
			if (other.szczegoly != null)
				return false;
		} else if (!szczegoly.equals(other.szczegoly))
			return false;
		if (opisZadania == null) {
			if (other.opisZadania != null)
				return false;
		} else if (!opisZadania.equals(other.opisZadania))
			return false;
		if (dataWykonania == null) {
			if (other.dataWykonania != null)
				return false;
		} else if (!dataWykonania.equals(other.dataWykonania))
			return false;
		if (numerKatalogowy == null) {
			if (other.numerKatalogowy != null)
				return false;
		} else if (!numerKatalogowy.equals(other.numerKatalogowy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (czasWykonania == null) {
			if (other.czasWykonania != null)
				return false;
		} else if (!czasWykonania.equals(other.czasWykonania))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Moneta [numerKatalogowy=" + numerKatalogowy + ", miejsceWykonania=" + miejsceWykonania + ", priorytet=" + priorytet + ", szczegoly="
				+ szczegoly + ", opisZadania=" + opisZadania + ", dataWykonania=" + dataWykonania + ", czasWykonania="
				+ czasWykonania + ", status=" + status + "]";
	}

}