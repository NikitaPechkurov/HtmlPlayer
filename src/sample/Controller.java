package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public HTMLEditor html;
    public WebView webView;
    public TextArea textArea;
    String INITIAL_TEXT3;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String t = "<link rel=\"stylesheet\" href=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\css\\pptxjs.css\">"+
"<link rel=\"stylesheet\" href=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\css\\nv.d3.min.css\"> <!-- for charts graphs -->"+
"<script type=\"text/javascript\" src=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\js\\jquery-1.11.3.min.js\"></script>"+
"<script type=\"text/javascript\" src=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\js\\jszip.min.js\"></script> <!-- v2.. , NOT v.3.. -->"+
"<script type=\"text/javascript\" src=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\js\\filereader.js\"></script> <!--https://github.com/meshesha/filereader.js -->"+
"<script type=\"text/javascript\" src=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\js\\d3.min.js\"></script> <!-- for charts graphs -->"+
"<script type=\"text/javascript\" src=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\js\\nv.d3.min.js\"></script> <!-- for charts graphs -->"+
"<script type=\"text/javascript\" src=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\js\\pptxjs.js\"></script>"+
"<script type=\"text/javascript\" src=\"C:\\Users\\Никита\\IdeaProjects\\HtmlRedactor\\src\\PPTXjs-master\\js\\divs2slides.js\"></script> <!-- for slide show -->"+
"<input type=\"file\" id=\"uploadFileInput\" /> <br>"+
                "<div id=\"slide-resolte-contaniner\" ></div> "+
"<script>"+
                "$(\"#slide-resolte-contaniner\").pptxToHtml({"+
                "pptxFileUrl: \"\","+
                "fileInputId: \"uploadFileInput\", /*id of input tag*/"+
                "slideMode: false,"+
                "slidesScale: \"20%\","+
                "keyBoardShortCut: false"+
    "});"+
"</script>";
        INITIAL_TEXT3 = t;//код для проигрывания по умолчанию
    }

    public void load(ActionEvent actionEvent) throws MalformedURLException {
        //File file = new File("C:/Users/Никита/Downloads/УЧЕБА/Инс и Мет Прогр Инженерии/Защита КП/презентация.pptx");
        //URL url = file.toURI().toURL();
        INITIAL_TEXT3 = textArea.getText();
        System.out.println("Код добавлен в переменную!");
        webView.getEngine().setJavaScriptEnabled(true);
        //System.out.println(webViewContext);
        //webView.getEngine().loadContent(webViewContext+INITIAL_TEXT3);
        webView.getEngine().loadContent(INITIAL_TEXT3,"text/html");
    }

    public void hndlOpenFile(ActionEvent actionEvent) throws MalformedURLException{
        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
        fileChooser.setTitle("Open Document");//Заголовок диалога
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
        fileChooser.getExtensionFilters().add(extFilter);
        Node source = (Node) actionEvent.getSource();
        Window theStage = source.getScene().getWindow();
        File file = fileChooser.showOpenDialog(theStage);//Указываем текущую сцену CodeNote.mainStage
        if (file != null) {
            //Open
            System.out.println("Процесс открытия файла");
        }
        URL url = file.toURI().toURL();
        webView.getEngine().setJavaScriptEnabled(true);
        webView.getEngine().load(url.toString());
    }
}
