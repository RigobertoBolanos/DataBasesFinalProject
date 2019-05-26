BEGIN
pkregistronivel2.pregistrarconstante('0', 'PENDIENTE', 'PENDIENTE');
pkregistronivel2.pregistrarconstante('1', 'ASIGNADA', 'ASIGNADA');
pkregistronivel2.pregistrarconstante('2', 'ATENDIDA', 'ATENDIDA');

pkregistronivel2.pregistrarconstante('3', 'VOZ', 'VOZ');
pkregistronivel2.pregistrarconstante('4', 'DATOS', 'DATOS');
pkregistronivel2.pregistrarconstante('5', 'INTEGRADO', 'INTEGRADO');

pkregistronivel2.pregistrarconstante('6', 'CREACION', 'CREACION');
pkregistronivel2.pregistrarconstante('7', 'MODIFICACION', 'MODIFICACION');
pkregistronivel2.pregistrarconstante('8', 'CANCELACION', 'CANCELACION');
pkregistronivel2.pregistrarconstante('9', 'RECLAMO', 'RECLAMO');
pkregistronivel2.pregistrarconstante('10', 'DAÑO', 'DAÑO');

pkregistronivel2.pregistrarcliente('1', 'Diego', TO_DATE('02-12-98', 'DD-MM-YY'), 'Cra 34 No.34-23', '33248383');

pkregistronivel2.pregistrarfuncionario('1', 'Diego', TO_DATE('02-12-98', 'DD-MM-YY'), 'Cra 34 No.34-23', '33248383');

pkregistronivel2.pregistrarsolicitud('NuevoProducto Voz', '0', '1', '6', NULL, '0');

pkregistronivel2.pregistrarconstantessolicitud('0', '0');
pkregistronivel2.pregistrarconstantessolicitud('0', '6');
pkregistronivel2.pregistrarconstantessolicitud('0', '3');

pkregistronivel2.pregistrarproductocliente(0, '1', '3');

pkregistronivel2.pborrarconstante('10');
pkregistronivel2.pborrarcliente('1');
pkregistronivel2.pborrarfuncionario('1');
pkregistronivel2.pborrarsolicitud('0');
pkregistronivel2.pborrarconstantesolicitud('0','3');
pkregistronivel2.pborrarproductocliente(0);
END;




