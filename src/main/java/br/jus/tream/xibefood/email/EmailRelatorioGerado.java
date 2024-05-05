package br.jus.tream.xibefood.email;

import br.jus.tream.xibefood.DTO.RelatorioEstoque;
import br.jus.tream.xibefood.DTO.RelatorioFaturamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailRelatorioGerado {
    @Autowired
    private EnviadorEmail enviador;

    public void enviar(RelatorioEstoque estoque, RelatorioFaturamento faturamento){
        enviador.enviarEmail(
                "Relatorio Scheduled gerados",
                "admin@email.com",
                """
                        Olá! Seus relatório foram gerados com sucesso!
                        %s
                        
                        %s
                        """.formatted(estoque, faturamento)
        );
    }
}
