package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stock_id_gen")
    @SequenceGenerator(name = "stock_id_gen", sequenceName = "stock_idstock_seq", allocationSize = 1)
    @Column(name = "idstock", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlot")
    private Lot idlot;

    @Size(max = 254)
    @Column(name = "codeqr", length = 254)
    private String codeqr;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "qunatitevendu")
    private BigDecimal qunatitevendu;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "datemodification")
    private LocalDate datemodification;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lot getIdlot() {
        return idlot;
    }

    public void setIdlot(Lot idlot) {
        this.idlot = idlot;
    }

    public String getCodeqr() {
        return codeqr;
    }

    public void setCodeqr(String codeqr) {
        this.codeqr = codeqr;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getQunatitevendu() {
        return qunatitevendu;
    }

    public void setQunatitevendu(BigDecimal qunatitevendu) {
        this.qunatitevendu = qunatitevendu;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public LocalDate getDatemodification() {
        return datemodification;
    }

    public void setDatemodification(LocalDate datemodification) {
        this.datemodification = datemodification;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

}