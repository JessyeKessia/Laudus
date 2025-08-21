# 🩺 Laudus

**Sistema de Gerenciamento de Exames Médicos e Emissão de Laudos**

## 💻 Diagrama de Classes da solução inicial


## 🖲️ Fluxo da solicitação do laudo

Recebimento do exame → com dados + prioridade.

Adição à fila de prioridade (PriorityQueue<ExamePrioritario>).

O sistema processa a fila com base na prioridade:

- URGENTE vai primeiro.
- POUCO_URGENTE vem depois.
- ROTINA por último.

Após sair da fila:

O exame é validado.

Se estiver válido, é criado e emitido o laudo.

O paciente é notificado.

O pagamento é processado, caso tenha descontos aplica o Decorater, via State.
- 

## 👾 Padrões de projeto utilizados


- Facade: Centralizando e simplificando o acesso
- Bridge: Separar tipos de laudos dos formatos de laudo (HTML, PDF, etc.).
- Observer: Notificar paciente por e-mail.
- Chain of Responsibility: Validar exames com diferentes regras
- Decorator: Aplicar descontos encadeáveis (idoso, convênio, campanhas).
- State: 	Controlar estado do pagamento: pagamento pendente, pagamento aprovado e pagamento cancelado.
- Strategy + Simple Factory: Definir prioridade do exame (Urgente, Pouco Urgente, Rotina).



## 🛠️ Tecnologias Utilizadas

<div style="display: inline-flex; align-items: center; background-color:rgb(216, 206, 173); color: black; padding: 6px 12px; border-radius: 6px; font-family: sans-serif; font-size: 14px; font-weight: bold;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" style="width: 20px; height: 20px; margin-right: 10px;">
  Java
</div>

## 👥 Contribuidores
<table>
  <tr>
   <td align="center">
      <a href="https://github.com/jessyekessia" title="gitHub">
        <img src="https://avatars.githubusercontent.com/u/128109017?v=4" width="100px;" alt="Foto de Jessye"/><br>
        <sub>
          <b>Jessye Késsia Pereira</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Nillocoelho" title="gitHub">
        <img src="https://avatars.githubusercontent.com/u/111874946?v=4" width="100px;" alt="Foto de Danillo"/><br>
        <sub>
          <b>Danillo Coelho</b>
        </sub>
      </a>
    </td>
      </a>
    </td>
  </tr>
</table>
