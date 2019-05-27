BEGIN
pkregistronivel2.pregistrarconstante('01', 'PENDIENTE', 'PENDIENTE');
pkregistronivel2.pregistrarconstante('02', 'ASIGNADA', 'ASIGNADA');
pkregistronivel2.pregistrarconstante('03', 'ATENDIDA', 'ATENDIDA');

pkregistronivel2.pregistrarconstante('11', 'VOZ', 'VOZ');
pkregistronivel2.pregistrarconstante('12', 'DATOS', 'DATOS');
pkregistronivel2.pregistrarconstante('13', 'INTEGRADO', 'INTEGRADO');

pkregistronivel2.pregistrarconstante('21', 'CREACION', 'CREACION');
pkregistronivel2.pregistrarconstante('22', 'MODIFICACION', 'MODIFICACION');
pkregistronivel2.pregistrarconstante('23', 'CANCELACION', 'CANCELACION');
pkregistronivel2.pregistrarconstante('24', 'RECLAMO', 'RECLAMO');
pkregistronivel2.pregistrarconstante('25', 'DAÑO', 'DAÑO');

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




