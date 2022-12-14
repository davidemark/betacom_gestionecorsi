create table amministratore(
codadmin varchar2(15),
nomeadmin varchar2(30) not null,
cognome varchar2(30) not null,
CONSTRAINT uc_amministratore UNIQUE(nomeadmin, cognome),
constraint p_codadmin primary key (codadmin));

create table docente(
coddocente int,
nomedocente varchar2(30) not null,
cognomedocente varchar2(30) not null,
cvdocente varchar2(100) not null,
constraint p_coddocente primary key (coddocente));

create table corso(
codcorso int,
nomecorso varchar2(30) not null,
datainiziocorso Date not null,
datafinecorso Date not null,
corsocosto number (6,2) not null,
commenticorso varchar2(200),
aulacorso varchar2(30) not null,
coddocente int,
constraint p_codcorso primary key (codcorso),
constraint f_coddocente foreign key (coddocente) references docente(coddocente));


create table corsista(
codcorsista int,
nomecorsista varchar2(30) not null,
cognomecorsista varchar2(30) not null,
precedentiformativi number (1) not null,
constraint p_codcorsista primary key (codcorsista));


create table corso_corsista(
codcorso int,
codcorsista int,
constraint f_codcorso foreign key(codcorso) references corso(codcorso) on delete cascade,
constraint f_codcorsista foreign key(codcorsista) references corsista(codcorsista) on delete cascade,
constraint p_cc primary key(codcorso, codcorsista));

-- Sequenze
create sequence corsista_seq;