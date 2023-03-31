drop table facultad;
drop table calendario;

create table facultad(
	id integer(8) primary key,
    nombre Varchar(20) not null,
    id_decano integer(15) not null #FK a tabla decano 
);

create table calendario(
	id Varchar(15),
    id_facultad integer(8),
    id_aprobador Varchar(15), #FK
    foreign key (id_facultad) references facultad(id),
    publicacion_oferta date not null,
    inicio_matriculas date not null,
    fin_matriculas date not null,
    inicio_ajustes date not null,
    fin_ajustes date not null,
    inicio_clases date not null,
    fin_clases date not null,
    inicio_examenes_finales date not null,
    fin_examenes_finales date not null,
    inicio_validaciones date not null,
    fin_validaciones date not null,
    inicio_habilitaciones date not null,
    fin_habilitaciones date not null,
    terminacion_oficial date not null,
    primary key(id, id_facultad)
);
