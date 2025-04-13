/*==============================================================*/
/* Table : Article                                              */
/*==============================================================*/
create table Article (
   idArticle            SERIAL               not null,
   idproduit            INT4                 null,
   codeQR               VARCHAR(254)         null,
   quantite             NUMERIC              null,
   prix                 NUMERIC              null,
   statut               BOOL                 null,
   dateExpiration       DATE                 null,
   dateCreation         DATE                 null,
   constraint PK_ARTICLE primary key (idArticle)
);

/*==============================================================*/
/* Index : ARTICLE_PK                                           */
/*==============================================================*/
create unique index ARTICLE_PK on Article (
idArticle
);

/*==============================================================*/
/* Index : ASSOCIATION6_FK                                      */
/*==============================================================*/
create  index ASSOCIATION6_FK on Article (
idproduit
);

/*==============================================================*/
/* Table : Catalogue                                            */
/*==============================================================*/
create table Catalogue (
   idCatalogue          SERIAL               not null,
   reference            VARCHAR(254)         null,
   label                VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   statut               BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_CATALOGUE primary key (idCatalogue)
);

/*==============================================================*/
/* Index : CATALOGUE_PK                                         */
/*==============================================================*/
create unique index CATALOGUE_PK on Catalogue (
idCatalogue
);

/*==============================================================*/
/* Table : DetailsProduit                                       */
/*==============================================================*/
create table DetailsProduit (
   idDetailsProduit     SERIAL               not null,
   idproduit            INT4                 null,
   caracteristique      VARCHAR(254)         null,
   valeur               VARCHAR(254)         null,
   statut               BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_DETAILSPRODUIT primary key (idDetailsProduit)
);

/*==============================================================*/
/* Index : DETAILSPRODUIT_PK                                    */
/*==============================================================*/
create unique index DETAILSPRODUIT_PK on DetailsProduit (
idDetailsProduit
);

/*==============================================================*/
/* Index : ASSOCIATION3_FK                                      */
/*==============================================================*/
create  index ASSOCIATION3_FK on DetailsProduit (
idproduit
);

/*==============================================================*/
/* Table : Famille                                              */
/*==============================================================*/
create table Famille (
   idFamille            SERIAL               not null,
   idCatalogue          INT4                 null,
   reference            VARCHAR(254)         null,
   label                VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   statut               BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_FAMILLE primary key (idFamille)
);

/*==============================================================*/
/* Index : FAMILLE_PK                                           */
/*==============================================================*/
create unique index FAMILLE_PK on Famille (
idFamille
);

/*==============================================================*/
/* Index : ASSOCIATION2_FK                                      */
/*==============================================================*/
create  index ASSOCIATION2_FK on Famille (
idCatalogue
);

/*==============================================================*/
/* Table : Image                                                */
/*==============================================================*/
create table Image (
   idImage              SERIAL               not null,
   idproduit            INT4                 null,
   pathImage            VARCHAR(254)         null,
   dateCreation         DATE                 null,
   dateModification     DATE                 null,
   constraint PK_IMAGE primary key (idImage)
);

/*==============================================================*/
/* Index : IMAGE_PK                                             */
/*==============================================================*/
create unique index IMAGE_PK on Image (
idImage
);

/*==============================================================*/
/* Index : ASSOCIATION4_FK                                      */
/*==============================================================*/
create  index ASSOCIATION4_FK on Image (
idproduit
);

/*==============================================================*/
/* Table : Lot                                                  */
/*==============================================================*/
create table Lot (
   idLot                SERIAL               not null,
   codeQR               VARCHAR(254)         null,
   libelle              VARCHAR(254)         null,
   statut               BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_LOT primary key (idLot)
);

/*==============================================================*/
/* Index : LOT_PK                                               */
/*==============================================================*/
create unique index LOT_PK on Lot (
idLot
);

/*==============================================================*/
/* Table : Produit                                              */
/*==============================================================*/
create table Produit (
   idproduit            SERIAL               not null,
   idFamille            INT4                 null,
   idUniteMesure        INT4                 null,
   codeQR               VARCHAR(254)         null,
   designation          VARCHAR(254)         null,
   description          VARCHAR(254)         null,
   prixUnite            NUMERIC              null,
   seuilAlerte          NUMERIC              null,
   statut               BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_PRODUIT primary key (idproduit)
);

/*==============================================================*/
/* Index : PRODUIT_PK                                           */
/*==============================================================*/
create unique index PRODUIT_PK on Produit (
idproduit
);

/*==============================================================*/
/* Index : ASSOCIATION1_FK                                      */
/*==============================================================*/
create  index ASSOCIATION1_FK on Produit (
idFamille
);

/*==============================================================*/
/* Index : ASSOCIATION11_FK                                     */
/*==============================================================*/
create  index ASSOCIATION11_FK on Produit (
idUniteMesure
);

/*==============================================================*/
/* Table : ReferenceArticle                                     */
/*==============================================================*/
create table ReferenceArticle (
   idReference          SERIAL               not null,
   idLot                INT4                 null,
   idArticle            INT4                 null,
   reference            VARCHAR(254)         null,
   emplacement          VARCHAR(254)         null,
   constraint PK_REFERENCEARTICLE primary key (idReference)
);

/*==============================================================*/
/* Index : REFERENCEARTICLE_PK                                  */
/*==============================================================*/
create unique index REFERENCEARTICLE_PK on ReferenceArticle (
idReference
);

/*==============================================================*/
/* Index : ASSOCIATION9_FK                                      */
/*==============================================================*/
create  index ASSOCIATION9_FK on ReferenceArticle (
idArticle
);

/*==============================================================*/
/* Index : ASSOCIATION12_FK                                     */
/*==============================================================*/
create  index ASSOCIATION12_FK on ReferenceArticle (
idLot
);

/*==============================================================*/
/* Table : Stock                                                */
/*==============================================================*/
create table Stock (
   idStock              SERIAL               not null,
   idLot                INT4                 null,
   codeQR               VARCHAR(254)         null,
   quantite             NUMERIC              null,
   qunatiteVendu        NUMERIC              null,
   statut               BOOL                 null,
   dateModification     DATE                 null,
   dateCreation         DATE                 null,
   constraint PK_STOCK primary key (idStock)
);

/*==============================================================*/
/* Index : STOCK_PK                                             */
/*==============================================================*/
create unique index STOCK_PK on Stock (
idStock
);

/*==============================================================*/
/* Index : ASSOCIATION10_FK                                     */
/*==============================================================*/
create  index ASSOCIATION10_FK on Stock (
idLot
);

/*==============================================================*/
/* Table : TypeVariete                                          */
/*==============================================================*/
create table TypeVariete (
   idTypeVarite         SERIAL               not null,
   label                VARCHAR(254)         null,
   typeValeur           VARCHAR(254)         null,
   statut               BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_TYPEVARIETE primary key (idTypeVarite)
);

/*==============================================================*/
/* Index : TYPEVARIETE_PK                                       */
/*==============================================================*/
create unique index TYPEVARIETE_PK on TypeVariete (
idTypeVarite
);

/*==============================================================*/
/* Table : UniteMesure                                          */
/*==============================================================*/
create table UniteMesure (
   idUniteMesure        SERIAL               not null,
   label                VARCHAR(254)         null,
   typeValeur           VARCHAR(254)         null,
   statut               BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_UNITEMESURE primary key (idUniteMesure)
);

/*==============================================================*/
/* Index : UNITEMESURE_PK                                       */
/*==============================================================*/
create unique index UNITEMESURE_PK on UniteMesure (
idUniteMesure
);

/*==============================================================*/
/* Table : Variete                                              */
/*==============================================================*/
create table Variete (
   idVariete            SERIAL               not null,
   idTypeVarite         INT4                 null,
   idproduit            INT4                 null,
   valeur               VARCHAR(254)         null,
   satut                BOOL                 null,
   dateCreation         DATE                 null,
   constraint PK_VARIETE primary key (idVariete)
);

/*==============================================================*/
/* Index : VARIETE_PK                                           */
/*==============================================================*/
create unique index VARIETE_PK on Variete (
idVariete
);

/*==============================================================*/
/* Index : ASSOCIATION7_FK                                      */
/*==============================================================*/
create  index ASSOCIATION7_FK on Variete (
idproduit
);

/*==============================================================*/
/* Index : ASSOCIATION8_FK                                      */
/*==============================================================*/
create  index ASSOCIATION8_FK on Variete (
idTypeVarite
);

alter table Article
   add constraint FK_ARTICLE_ASSOCIATI_PRODUIT foreign key (idproduit)
      references Produit (idproduit)
      on delete restrict on update restrict;

alter table DetailsProduit
   add constraint FK_DETAILSP_ASSOCIATI_PRODUIT foreign key (idproduit)
      references Produit (idproduit)
      on delete restrict on update restrict;

alter table Famille
   add constraint FK_FAMILLE_ASSOCIATI_CATALOGU foreign key (idCatalogue)
      references Catalogue (idCatalogue)
      on delete restrict on update restrict;

alter table Image
   add constraint FK_IMAGE_ASSOCIATI_PRODUIT foreign key (idproduit)
      references Produit (idproduit)
      on delete restrict on update restrict;

alter table Produit
   add constraint FK_PRODUIT_ASSOCIATI_FAMILLE foreign key (idFamille)
      references Famille (idFamille)
      on delete restrict on update restrict;

alter table Produit
   add constraint FK_PRODUIT_ASSOCIATI_UNITEMES foreign key (idUniteMesure)
      references UniteMesure (idUniteMesure)
      on delete restrict on update restrict;

alter table ReferenceArticle
   add constraint FK_REFERENC_ASSOCIATI_LOT foreign key (idLot)
      references Lot (idLot)
      on delete restrict on update restrict;

alter table ReferenceArticle
   add constraint FK_REFERENC_ASSOCIATI_ARTICLE foreign key (idArticle)
      references Article (idArticle)
      on delete restrict on update restrict;

alter table Stock
   add constraint FK_STOCK_ASSOCIATI_LOT foreign key (idLot)
      references Lot (idLot)
      on delete restrict on update restrict;

alter table Variete
   add constraint FK_VARIETE_ASSOCIATI_PRODUIT foreign key (idproduit)
      references Produit (idproduit)
      on delete restrict on update restrict;

alter table Variete
   add constraint FK_VARIETE_ASSOCIATI_TYPEVARI foreign key (idTypeVarite)
      references TypeVariete (idTypeVarite)
      on delete restrict on update restrict;

INSERT INTO Catalogue (reference, label, description, statut, dateCreation) VALUES
('CAT-001', 'Électronique', 'Produits électroniques divers', true, '2025-04-01'),
('CAT-002', 'Maison', 'Articles pour la maison et déco', true, '2025-04-01'),
('CAT-003', 'Alimentation', 'Produits alimentaires secs et frais', true, '2025-04-02'),
('CAT-004', 'Vêtements', 'Habits pour hommes, femmes et enfants', true, '2025-04-02'),
('CAT-005', 'Papeterie', 'Fournitures de bureau et scolaires', false, '2025-04-03'),
('CAT-006', 'Beauté', 'Cosmétiques et soins de beauté', true, '2025-04-03'),
('CAT-007', 'Jardinage', 'Outils et équipements pour jardin', true, '2025-04-04'),
('CAT-008', 'Informatique', 'Matériel informatique et périphériques', true, '2025-04-04'),
('CAT-009', 'Sports', 'Équipements sportifs et accessoires', true, '2025-04-05'),
('CAT-010', 'Jouets', 'Jeux et jouets pour tous les âges', true, '2025-04-05');
