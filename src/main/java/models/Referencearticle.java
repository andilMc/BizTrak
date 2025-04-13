package models;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "referencearticle")
public class Referencearticle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referencearticle_id_gen")
    @SequenceGenerator(name = "referencearticle_id_gen", sequenceName = "referencearticle_idreference_seq", allocationSize = 1)
    @Column(name = "idreference", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idlot")
    private Lot idlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idarticle")
    private Article idarticle;

    @Size(max = 254)
    @Column(name = "reference", length = 254)
    private String reference;

    @Size(max = 254)
    @Column(name = "emplacement", length = 254)
    private String emplacement;

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

    public Article getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Article idarticle) {
        this.idarticle = idarticle;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

}