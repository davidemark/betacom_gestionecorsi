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
insert into corso values(1, 'JAVA', '19-dic-2022', '15-nov-2023', 1700, 'molto bello', 'a1', 1); -- corso che deve iniziare
insert into corso values(2, 'PHP', '20-gen-2023', '12-feb-2023', 700, 'poco utile', 'a2', 1); -- corso che deve iniziare
insert into corso values(3, 'XML', '15-mar-2023', '13-mag-2023', 500, 'utile', 'a3', 3); -- corso che deve iniziare
insert into corso values(4, 'CSS', '23-set-2023', '16-dic-2023', 800, 'interessante', 'a4', 5); -- corso che deve iniziare
insert into corso values(5, 'HTML', '5-ott-2023', '14-nov-2023', 450, 'fondamentale', 'a5', 7); -- corso che deve iniziare
insert into corso values(6, 'JS', '17-nov-2022', ' 17-feb-2023', 2000, 'molto utile', 'a6', 9); -- corso in corso
insert into corso values(7, 'SPRING', '7-nov-2022', '18-gen-2023', 1800, 'istruttivo', 'a7', 8); -- corso in corso
insert into corso values(8, 'C', '5-ott-2022', '17-nov-2022', 999, 'formativo', 'a8', 6); -- corso scaduto
insert into corso values(9, 'PYTHON', '11-nov-2022', '16-nov-2022', 1500, 'troppo mainstream', 'a9', 4); -- corso scaduto
insert into corso values(10, 'C++', '15-dic-2025', '15-dic-2025', 1099, 'formativo++', 'a10', 2); -- corso non valido

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