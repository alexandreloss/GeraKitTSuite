/*
 * JanelaPrincipal.java
 *
 * Created on February 10, 2010, 12:38 PM
 */

package br.org.tracksource.gerakittsuite;

import br.org.tracksource.gerakittsuite.zipador.Zipador;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

/**
 *
 * @author  ur5m
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    
    public static Color MENSAGEM_ERRO = Color.red;          // Constante para a cor de mensagens de erro
    public static Color MENSAGEM_AVISO = Color.getHSBColor(20, 240, 120);      // Constante para a cor de mensagens de aviso
    public static Color MENSAGEM_INFORMACAO = Color.black;  // Constante para a cor de mensagens de informa��o
    public String versaoTSuite; // constante provisoriamente
    
    private GeraKit Tarefa;

    /** Creates new form JanelaPrincipal */
    public JanelaPrincipal() {
        initComponents();

        //carregando os icones de janela//////
        ArrayList<Image> lstIcones = new ArrayList<Image>();
        URL imgURL = getClass().getResource("icone_gerakit_16.png");
        ImageIcon icone = new ImageIcon(imgURL);
        lstIcones.add(icone.getImage());
        imgURL = getClass().getResource("icone_gerakit_32.png");
        icone = new ImageIcon(imgURL);
        lstIcones.add(icone.getImage());
        this.setIconImages(lstIcones);
        //////////////////////////////////////

        this.setTitle("Gerador de Kit do TSuite");
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
}

    /**
     * Funcao chamada por menus e botoes para quando se quer
     * modificar as configuracoes do MapStudio.
     */
    public void evocarDialogoDeConfiguracoes(){
        new DialogoConfiguracoes(this, true);
    }
    
    public void evocarGeracaoDoKit() {
        Tarefa = new GeraKit(menuGeraKit);
        Tarefa.execute();
    }
    
    public void printLineSysout (Color c, String Texto) {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,StyleConstants.Foreground, c);  // atribui cor do texto
        int len = jSysout.getDocument().getLength(); // obtem o tamanho total da lista

        jSysout.setFont(new Font("Arial", Font.PLAIN, 10));
        jSysout.setCaretPosition(len);  // posiciona no final da lista, sem selecioar
        jSysout.setCharacterAttributes(aset, false);
        jSysout.replaceSelection(Texto+"\n"); // insere texto no final da lista
        jSysout.setCaretPosition(jSysout.getCaretPosition()+Texto.length()); // posiciona no final da lista
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jSysout = new javax.swing.JTextPane();
        barraMenu = new javax.swing.JMenuBar();
        menuPrincipal = new javax.swing.JMenu();
        menuGeraKit = new javax.swing.JMenuItem();
        menuConfigurar = new javax.swing.JMenuItem();
        separadormenu = new javax.swing.JSeparator();
        menuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(880, 700));
        setPreferredSize(new java.awt.Dimension(880, 700));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                JanelaPrincipal.this.windowClosing(evt);
            }
        });

        jScrollPane1.setViewportView(jSysout);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        barraMenu.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N

        menuPrincipal.setText("A��es");
        menuPrincipal.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N

        menuGeraKit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuGeraKit.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        menuGeraKit.setText("Gerar Kit");
        menuGeraKit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGeraKit_Clicked(evt);
            }
        });
        menuPrincipal.add(menuGeraKit);

        menuConfigurar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuConfigurar.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        menuConfigurar.setText("Configurar...");
        menuConfigurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfigurar_Clicked(evt);
            }
        });
        menuPrincipal.add(menuConfigurar);
        menuPrincipal.add(separadormenu);

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        menuSair.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSair_Clicked(evt);
            }
        });
        menuPrincipal.add(menuSair);

        barraMenu.add(menuPrincipal);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuConfigurar_Clicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfigurar_Clicked
        this.evocarDialogoDeConfiguracoes();
    }//GEN-LAST:event_menuConfigurar_Clicked

    private void menuGeraKit_Clicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGeraKit_Clicked
        this.evocarGeracaoDoKit();
    }//GEN-LAST:event_menuGeraKit_Clicked

    private void windowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosing
        this.menuSair_Clicked(null);
    }//GEN-LAST:event_windowClosing

    private void menuSair_Clicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSair_Clicked
        try {
            Configuracoes.salvarConfiguracoes();
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao salvar arquivo de configura��es: " + ex.getMessage());
        }
        GeraKitTSuite.encerrar();       
    }//GEN-LAST:event_menuSair_Clicked

    // Copia um arquivo, sobrescrevendo o destino se arquivo ja existir
    private boolean copyFile(String sourceFile, String pathDestino) {  
         File source = new File (sourceFile);
         File destination = new File (pathDestino + File.separator + sourceFile);
         if (destination.exists())  
             destination.delete();  

         FileChannel sourceChannel = null;  
         FileChannel destinationChannel = null;  

         try {  
             sourceChannel = new FileInputStream(source).getChannel();  
             destinationChannel = new FileOutputStream(destination).getChannel();  
             sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);  
             if (sourceChannel != null && sourceChannel.isOpen())  
                 sourceChannel.close();  
             if (destinationChannel != null && destinationChannel.isOpen())  
                 destinationChannel.close();
             printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Copiado arquivo atualizado \""+ sourceFile + "\" para " + pathDestino + ".");
             return true;
         }
         catch (IOException ex) {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro ao copiar arquivo \""+ sourceFile + "\":\n " + Util.getStackTrace(ex));
            return false;
         }
    }  
    
    // Copia um arquivo, sobrescrevendo o destino se arquivo ja existir
    private boolean copyFile(String sourceFile) {
        Path origem = Paths.get(sourceFile);
        Path destino = Paths.get(".\\" + origem.getFileName().toString());
        try {
            if (Files.deleteIfExists(destino)) {
                Files.copy(origem, destino);
            }
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Copiado arquivo atualizado \""+ sourceFile + "\" para a pasta corrente.");
            return true;
        } catch (IOException ex) {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro ao copiar arquivo \""+ sourceFile + "\":\n " + Util.getStackTrace(ex));
            return false;
        }
    } 
    
    // Verifica se todos os parametros foram definidos
    private boolean configuracoesOk () {
        boolean retorno = true;
        if(Configuracoes.strPastaTSuiteAtualizado == null || Configuracoes.strPastaTSuiteAtualizado.isEmpty()) retorno = false;
        if(Configuracoes.strPastaDestinoPoisTracksXml == null || Configuracoes.strPastaDestinoPoisTracksXml.isEmpty()) retorno = false;
        if(Configuracoes.strPastaDestinoTabelaMunicipioXml == null || Configuracoes.strPastaDestinoTabelaMunicipioXml.isEmpty()) retorno = false;
        if(Configuracoes.strIssTSuite == null || Configuracoes.strIssTSuite.isEmpty()) retorno = false;
        if(Configuracoes.strInnoSetup == null || Configuracoes.strInnoSetup.isEmpty()) retorno = false;
        if (!retorno)
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "N�o � poss�vel gerar kit pois h� pelo menos um par�metro em branco. Favor revisar as configura��es.");
        return retorno;
    }
    
    // Atualiza os arquivos de configura��o do TSuite
    private boolean atualizarArquivos() {
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Atualiza��o dos Arquivos de Configura��o do TSuite");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");        
        //ler os valores de verificacao de XMLs do site
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Lendo valores de verifica��o do site");
        if (!GeraKitTSuite.lerValoresVerificacaoXMLdoSite()) return false;

        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Verificando e atualizando XMLs locais de regras de valida��o");
        if (!GeraKitTSuite.atualizarXMLs()) return false;

        //se o GTM de limites n�o existir, baixa o ZIP contendo-o do site.
        try{
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Baixando o GTM de limites do projeto");
            if (!GeraKitTSuite.baixarZIPGTMLimites()) return false;
        }catch (Exception ex){
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro ao baixar o ZIP com todos os limites do site:\n " + Util.getStackTrace(ex));
            return false;
        }

        //verifica se precisa atualizar o GTM de limites
        try{
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Verificando necessidade de atualiza��o de limites");
            if (!GeraKitTSuite.atualizarLimites()) return false;
        }catch (Exception ex){
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro ao verificar atualiza��o dos limites:\n " + Util.getStackTrace(ex));
            return false;
        }
        if (!salvarTsuiteUpdate()) return false;            // Salva o arquivo tsuite_update.xml
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Concluida a atualiza��o dos arquivos xml e de limites.\n");
        return true;
    }
    
    // Salva o arquivo tsuite_update.xml
    private boolean salvarTsuiteUpdate (){
        try {
            Configuracoes.salvarUpdate();
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Atualizado arquivo \"tsuite_update.xml\".");
            return true;
        }
        catch (FileNotFoundException ex) {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro ao atualizar arquivo \"tsuite_update.xml\":\n " + Util.getStackTrace(ex));
            return false;
        }
    }
    
    // Copia os arquivos xml e de limites para os devidos
    private boolean copiarArquivosParaDestinos()   {
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "C�pia dos arquivos de configura��o atualizados do TSuite");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");        
        if (!this.copyFile("pois.xml", Configuracoes.strPastaDestinoPoisTracksXml)) return false;
        if (!this.copyFile("tracks.xml", Configuracoes.strPastaDestinoPoisTracksXml)) return false;
        if (!this.copyFile("tabela_municipios.xml", Configuracoes.strPastaDestinoTabelaMunicipioXml)) return false;
        if (!this.copyFile(Configuracoes.strPastaTSuiteAtualizado+"\\TSuite.jar")) return false;
        // Verifica a existencia de base-AUXILIAR-BR.gtm
        if (Util.isArquivoExiste("base-AUXILIAR-BR.gtm")) 
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Verificado a existencia do arquivo atualizado \"base-AUXILIAR-BR.gtm\"");
        else{
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Arquivo \"base-AUXILIAR-BR.gtm\" n�o encontrado.");
            return false;
        }
        if (Util.isArquivoExiste("tsuite_update.xml")) 
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Verificado a existencia do arquivo atualizado \"tsuite_update.xml\"");
        else
        {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Arquivo \"tsuite_update.xml\" n�o encontrado.");
            return false;
        }
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Concluida a copia dos arquivos atualizados.\n");
        return true;
    }
    
    // Obtem a vers�o do TSuite que se est� gerando o kit
    private boolean obterVersaoTSuite() {
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Obten��o da vers�o atualizada do TSuite");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");        
        String commandTSuite[] = {"java", "-cp", "TSuite.jar", "br.org.tracksource.tsuite.Console", "-version"};
        try {
            Process proc = Runtime.getRuntime().exec (commandTSuite);
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), 0); 
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), 2); 
            errorGobbler.start(); 
            outputGobbler.start(); 
            int exitVal = proc.waitFor(); 
            if (exitVal == 0) {
                printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Vers�o do TSuite: " + this.versaoTSuite + "\n");
                return true;
            }
            else{
                printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro ao tentar obter a vers�o atual do TSuite.\n");
                return false;
            }
        }
        catch (Exception ex) {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro ao ofuscar TSuite.jar:\n " + Util.getStackTrace(ex));
            return false;
        }
    }
    
    // Executa Inno Setup para gera��o do kit
    private boolean executarInnoSeteup() {
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Gera��o do kit com o Inno Setup");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");        
        String commandInnoSetup[] = {"ISCC","/Q", "p1"};
        int commandInnoSetup_P1 = 0;  // posicao do comando do InnoSetup
        int commandInnoSetup_P2 = 2;  // posicao do parametro do comando
        commandInnoSetup[commandInnoSetup_P1] = "\"" + Configuracoes.strInnoSetup + "\"";
        commandInnoSetup[commandInnoSetup_P2] = "\"" + Configuracoes.strIssTSuite + "\"";
        try {
            Process proc = Runtime.getRuntime().exec (commandInnoSetup);
            StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), 0); 
            StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), 1); 
            errorGobbler.start(); 
            outputGobbler.start(); 
            int exitVal = proc.waitFor(); 
            if (exitVal == 0) {
                printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Concluida a gera��o do kit de setup execut�vel: \"InstalaTSuite_"+this.versaoTSuite + ".exe\"\n");
                return true;
            }
            else{
                printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro na gera��o do kit com o Inno Setup.\n");
                return false;
            }
        }
        catch (Exception ex) {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro na gera��o do kit com o Inno Setup:\n " + Util.getStackTrace(ex));
            return false;
        }
    }
    
    // Gera a vers�o zip do kit
    private boolean gerarKitZip() {
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Gera��o do kit vers�o ZIP com o jar e manual");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");        
        String nomeZip = ".\\Output\\TSuite_" + versaoTSuite + ".zip";
        try {
            Zipador.ziparKitSetupTSuite(nomeZip);
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Concluida a gera��o do kit zipado: \""+ nomeZip + "\"\n");
            return true;
        }
        catch (Exception ex) {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro na gera��o do kit com o Inno Setup:\n " + Util.getStackTrace(ex));
            return false;
        }
    }
    
    private ArrayList<String> getPalavrasAleatorias (int qtdPalavras) {
        ArrayList<String> lista = new ArrayList<String>();
        Random rand = new Random();
        int maxlength = 8;
        int minlength = 3;
        final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0;i<qtdPalavras;i++) {
            String word = "";
            int curlenght = rand.nextInt(maxlength-minlength) + minlength;
            while(word.length() < curlenght){
                int x = rand.nextInt(chars.length());
                word = word + chars.charAt(x);
            }
            lista.add(word);
        }
        return lista;
    }
    
    // Atualiza a vers�o do TSuite no arquivo de configura��o do Inno
    private boolean atualizarVersaoConfigInno(){ 
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Atualiza��o da vers�o do TSuite no arquivo de configura��o do Inno Setup");
        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "************************************************************************************************************");        
        try {
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Lendo arquivo \"" + Configuracoes.strIssTSuite + "\"..." );
            String texto = "";
            FileReader arq = new FileReader(Configuracoes.strIssTSuite);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            texto += linha;
            while (linha != null) {
                linha = lerArq.readLine();
                if (linha != null) {
                    if (linha.contains("AppVerName"))
                        texto += "\nAppVerName=TrackSource TSuite " + this.versaoTSuite;
                    else if (linha.contains("AppVersion"))
                    {
                        Date now = new Date();
                        texto += "\nAppVersion=" + this.versaoTSuite + " " + new SimpleDateFormat("yyyy-MM-dd").format(now);
                    }
                    else if (linha.contains("OutputBaseFilename"))
                        texto += "\nOutputBaseFilename=InstalaTSuite_" + this.versaoTSuite ;
                    else
                        texto += "\n" + linha;
                }
            }
            arq.close();
            // grava arquivo
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Gravando arquivo \"" + Configuracoes.strIssTSuite + "\"..." );
            PrintWriter writer;
            writer = new PrintWriter(new FileOutputStream(Configuracoes.strIssTSuite, false));
            writer.println(texto);
            writer.close();
            printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "Concluida a atualiza�ao da vers�o do TSuite nas configura��es do Inno Setup.\n");
            return true;
        }
        catch (Exception ex) {
            printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro na atualiza��o da vers�o do TSuite nas configura��es do Inno Setup :\n " + Util.getStackTrace(ex));
            return false;
        }
    }  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jSysout;
    private javax.swing.JMenuItem menuConfigurar;
    private javax.swing.JMenuItem menuGeraKit;
    private javax.swing.JMenu menuPrincipal;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JSeparator separadormenu;
    // End of variables declaration//GEN-END:variables
 
    /***************************************************************************************************
     * Subclasse com para executar o processamento principal
     */
    class GeraKit extends SwingWorker<Void, Void> {

        private javax.swing.JMenuItem menuGeraKit;

        public GeraKit(javax.swing.JMenuItem menugerakit){
            super();
            this.menuGeraKit = menugerakit;
        }

        @Override
        public Void doInBackground() {
            this.menuGeraKit.setEnabled(false);
             if (this.gerarKit())
                 printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, "\n>>>>>> Gera��o do kit conclu�da com sucesso!\nInstale em sua m�quina e confira se est� tudo certo.\n");
             else
                 printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "\n>>>>>> Gera��o do kit abortada. Analise o problema e tente novamente.\n");
             return null;
        }

        /*
         * Executed in event dispatching thread
         */
        @Override
        public void done() {
            this.menuGeraKit.setEnabled(true);
        }
        
        private boolean gerarKit () {
            jSysout.setText("");                                // Limpa a systout
            if (!configuracoesOk()) return false;               // Verifica se todos os parametros foram definidos
            if (!atualizarArquivos()) return false;             // Atualiza os arquivos de configura��o do TSuite
            if (!copiarArquivosParaDestinos()) return false;    // Copia os arquivos xml e de limites para os devidos destinos
            if (!obterVersaoTSuite()) return false;             // Obtem a vers�o do TSuite que se est� gerando o kit
            if (!atualizarVersaoConfigInno()) return false;     // Atualiza a vers�o do TSuite no arquivo de configura��o do Inno
            if (!executarInnoSeteup()) return false;            // Executa Inno Setup para gera��o do kit
            if (!gerarKitZip()) return false;                   // Gera a vers�o zip do kit
            return true; // correu tudo bem
        }
        
    }
    
    class StreamGobbler extends Thread { 
        InputStream is; 
        int tipo; 

        /**
         * @ construtor
         * @param is InputSream
         * @param type 0 - stdErr
         *             1 - stdOut
         *             2 - set TSuite Version
         */
        StreamGobbler(InputStream is, int type) { 
            this.is = is; 
            this.tipo = type; 
        } 

        public void run() { 
            try  { 
                InputStreamReader isr = new InputStreamReader(is); 
                BufferedReader br = new BufferedReader(isr); 
                String line=null; 
                while ( (line = br.readLine()) != null)
                    if(tipo == 0)
                        printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, line); 
                    else if (tipo == 1)
                        printLineSysout(JanelaPrincipal.MENSAGEM_INFORMACAO, line); 
                    else
                        versaoTSuite = line; 
            } catch (IOException ioe)  { 
                printLineSysout(JanelaPrincipal.MENSAGEM_ERRO, "Erro interno na leitura de StdErr:\n " + Util.getStackTrace(ioe));
            } 
        } 
    } 

}
