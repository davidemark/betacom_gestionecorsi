-- docente
insert into docente values(1, 'Massimo', 'Ghianda', 'JAVA, PHP, XML, CSS, HTML, JS, SPRING, C, C++, PHYTON');
insert into docente values(2, 'Mario', 'Panino', 'PHYTON, HTML');
insert into docente values(3, 'Anna', 'Provola', 'JAVA, PHP, XML');
insert into docente values(4, 'Alexandra', 'Gastanifrinzi', 'JAVA, PHP, XML, CSS, HTML, JS, SPRING, C, C++, PHYTON');
insert into docente values(5, 'Irene', 'Mazzotta', 'HTML, JS, SPRING');
insert into docente values(6, 'Patrizio', 'Conte', 'PHP, PHYTON');
insert into docente values(7, 'Mirko', 'Lagonna', 'XML, C, C++');
insert into docente values(8, 'Elena', 'Grandi', 'CSS, HTML, JS');
insert into docente values(9, 'Pippo', 'Baudo', 'SPRING');
insert into docente values(10, 'Giancarlo', 'Magalli', 'JAVA, PHP, XML, CSS, HTML, JS, SPRING, C, C++, PHYTON');

-- corso
insert into corso values(1, 'JAVA', '12-mag-2020', '15-mag-2021', 1700, 'molto bello', 'a1',1);
insert into corso values(2, 'PHP', '18-dic-2020', '12-gen-2021', 700, 'poco utile', 'a2',1);
insert into corso values(3, 'XML', '3-dic-2020', '13-feb-2021', 500, 'utile', 'a3',3);
insert into corso values(4, 'CSS', '23-set-2020', '16-dic-2020', 800, 'interessante', 'a4',5);
insert into corso values(5, 'HTML', '5-ott-2020', '14-nov-2020', 450, 'fondamentale', 'a5',7);
insert into corso values(6, 'JS', '10-lug-2020', '17-lug-2020', 2000, 'molto utile', 'a6',9);
insert into corso values(7, 'SPRING', '7-mag-2020', '18-mag-2020', 1800, 'istruttivo', 'a7',8);
insert into corso values(8, 'C', '21-nov-2020', '19-dic-2020', 999, 'formativo', 'a8',6);
insert into corso values(9, 'PYTHON', '11-nov-2020', '10-mar-2021', 1500, 'troppo mainstream', 'a9',4);
insert into corso values(10, 'C++', '8-gen-2020', '15-feb-2020', 1099, 'formativo++', 'a10',2);

-- corsista
insert into corsista values(corsista_seq.nextval, 'Lucio', 'Mastropietro', 1);
insert into corsista values(corsista_seq.nextval, 'Davide Mark', 'Sardella', 0);
insert into corsista values(corsista_seq.nextval, 'Andrea', 'Toraldo', 1);
insert into corsista values(corsista_seq.nextval, 'Gabriele', 'D''Ortenzi', 0);
insert into corsista values(corsista_seq.nextval, 'Riccardo', 'Padoan', 1);



-- amministratore
insert into amministratore values('admin', 'admin', 'admin');

-- corso_corsista
insert into corso_corsista values (7,1);
insert into corso_corsista values (9,4);
insert into corso_corsista values (7,5);
insert into corso_corsista values (4,1);
insert into corso_corsista values (5,3);
insert into corso_corsista values (8,2);

commit