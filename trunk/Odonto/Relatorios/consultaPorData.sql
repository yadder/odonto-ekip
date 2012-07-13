SELECT
     *,
     tb_consulta.`data_consulta` AS tb_consulta_data_consulta,
     tb_consulta.`status_consulta` AS tb_consulta_status_consulta,
     tb_consulta.`hora_inicio` AS tb_consulta_hora_inicio,
     tb_consulta.`hora_fim` AS tb_consulta_hora_fim,
     tb_usuario.`nome_usuario` AS tb_usuario_nome_usuario,
     tb_consulta.`paciente_idUsuario` AS tb_consulta_paciente_idUsuario
FROM
     `tb_usuario` tb_usuario INNER JOIN `tb_paciente` tb_paciente ON tb_usuario.`id_usuario` = tb_paciente.`idUsuario`
     LEFT OUTER JOIN `tb_consulta` tb_consulta ON tb_paciente.`idUsuario` = tb_consulta.`paciente_idUsuario`