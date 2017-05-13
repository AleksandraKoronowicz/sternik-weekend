package projectapp.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//@Entity
//@XmlRootElement
public class Moneta {

//  @NotNull
//  @Id
  private Long numerPorzadkowy;
	
//	@NotNull
	private Long priorytet;
	
	//@Size(min=2, max=30, message = "{Size.moneta.opisZadania}")
//	@Size(min=2, max=30, message = "opisZadania should be in the range [{min}...{max}]")
	private String opisZadania;
//	@NotEmpty
	private String miejsceWykonania;
//	@NotNull
	private BigDecimal czasRealizacji;
//	@NotNull
	private Date dataRealizacji;
//	@NotEmpty
	private String dodatkoweInformacje;
//	@NotNull
	private Status status;

	
	
	public static Moneta produceMoneta(Long numerPorzadkowy, String dodatkoweInformacje, Long priorytet, String miejsceWykonania, String opisZadania,
			Date dataRealizacji, BigDecimal czasRealizacji, Status status) {
		Moneta m = new Moneta();
		m.numerPorzadkowy = numerPorzadkowy;
		m.dodatkoweInformacje = dodatkoweInformacje;
		m.priorytet = priorytet;
		m.opisZadania = opisZadania;
		m.miejsceWykonania = miejsceWykonania;
		m.czasRealizacji = czasRealizacji;
		m.dataRealizacji = dataRealizacji;
		m.status = status;
		return m;
	}

	public Long getNumerPorzadkowy() {
		return numerPorzadkowy;
	}

	public Long getPriorytet() {
		return priorytet;
	}

	public String getOpisZadania() {
		return opisZadania;
	}

	public String getMiejsceWykonania() {
		return miejsceWykonania;
	}

	public BigDecimal getCzasRealizacji() {
		return czasRealizacji;
	}

	public Date getdataRealizacji() {
		return dataRealizacji;
	}

	public String getDodatkoweInformacje() {
		return dodatkoweInformacje;
	}

	public Status getStatus() {
		return status;
	}

	public void setNumerPorzadkowy(Long numerPorzadkowy) {
		this.numerPorzadkowy = numerPorzadkowy;
	}

	public void setPriorytet(Long priorytet) {
		this.priorytet = priorytet;
	}

	public void setoOisZadania(String opisZadania) {
		this.opisZadania = opisZadania;
	}

	public void setMiejsceWykonania(String miejsceWykonania) {
		this.miejsceWykonania = miejsceWykonania;
	}

	public void setCzasRealizacji(BigDecimal czasRealizacji) {
		this.czasRealizacji = czasRealizacji;
	}

	public void setDataRealizacji(Date dataRealizacji) {
		this.dataRealizacji = dataRealizacji;
	}

	public void setDodatkoweInformacje(String dodatkoweInformacje) {
		this.dodatkoweInformacje = dodatkoweInformacje;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opisZadania == null) ? 0 : opisZadania.hashCode());
		result = prime * result + ((czasRealizacji == null) ? 0 : czasRealizacji.hashCode());
		result = prime * result + ((dataRealizacji == null) ? 0 : dataRealizacji.hashCode());
		result = prime * result + ((dodatkoweInformacje == null) ? 0 : dodatkoweInformacje.hashCode());
		result = prime * result + ((priorytet == null) ? 0 : priorytet.hashCode());
		result = prime * result + ((numerPorzadkowy == null) ? 0 : numerPorzadkowy.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((miejsceWykonania == null) ? 0 : miejsceWykonania.hashCode());
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
		if (opisZadania == null) {
			if (other.opisZadania != null)
				return false;
		} else if (!opisZadania.equals(other.opisZadania))
			return false;
		if (czasRealizacji == null) {
			if (other.czasRealizacji != null)
				return false;
		} else if (!czasRealizacji.equals(other.czasRealizacji))
			return false;
		if (dataRealizacji == null) {
			if (other.dataRealizacji != null)
				return false;
		} else if (!dataRealizacji.equals(other.dataRealizacji))
			return false;
		if (dodatkoweInformacje == null) {
			if (other.dodatkoweInformacje != null)
				return false;
		} else if (!dodatkoweInformacje.equals(other.dodatkoweInformacje))
			return false;
		if (priorytet == null) {
			if (other.priorytet != null)
				return false;
		} else if (!priorytet.equals(other.priorytet))
			return false;
		if (numerPorzadkowy == null) {
			if (other.numerPorzadkowy != null)
				return false;
		} else if (!numerPorzadkowy.equals(other.numerPorzadkowy))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (miejsceWykonania == null) {
			if (other.miejsceWykonania != null)
				return false;
		} else if (!miejsceWykonania.equals(other.miejsceWykonania))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Moneta [numerPorzadkowy=" + numerPorzadkowy + ", priorytet=" + priorytet + ", opisZadania=" + opisZadania + ", miejsceWykonania="
				+ miejsceWykonania + ", czasRealizacji=" + czasRealizacji + ", dataRealizacji=" + dataRealizacji + ", dodatkoweInformacje="
				+ dodatkoweInformacje + ", status=" + status + "]";
	}

}