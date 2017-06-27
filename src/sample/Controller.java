package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Random;

public class Controller {
    int i, k, tip2, tip3, tio3, tio4, tio5, tio6, tno, too, too2, to, tpr, tpr2, tp, tos1, tos2;
    private ObservableList<Table> usersData = FXCollections.observableArrayList();
    @FXML
    private TableView<Table> tableUsers;

    @FXML
    private TableColumn<Table, Integer> I;

    @FXML
    private TableColumn<Table, Integer> K;

    @FXML
    private TableColumn<Table, Integer> TIP;

    @FXML
    private TableColumn<Table, Integer> TIO;

    @FXML
    private TableColumn<Table, Integer> TP;

    @FXML
    private TableColumn<Table, Integer> TNO;

    @FXML
    private TableColumn<Table, Integer> TOO;

    @FXML
    private TableColumn<Table, Integer> TO;

    @FXML
    private TableColumn<Table, Integer> TPR;

    @FXML
    private void initialize() {

        // устанавливаем тип и значение которое должно хранится в колонке
        I.setCellValueFactory(new PropertyValueFactory<Table, Integer>("I"));
        K.setCellValueFactory(new PropertyValueFactory<Table, Integer>("K"));
        TIP.setCellValueFactory(new PropertyValueFactory<Table, Integer>("TIP"));
        TIO.setCellValueFactory(new PropertyValueFactory<Table, Integer>("TIO"));
        TP.setCellValueFactory(new PropertyValueFactory<Table, Integer>("TP"));
        TNO.setCellValueFactory(new PropertyValueFactory<Table, Integer>("TNO"));
        TOO.setCellValueFactory(new PropertyValueFactory<Table, Integer>("TOO"));
        TO.setCellValueFactory(new PropertyValueFactory<Table, Integer>("TO"));
        TPR.setCellValueFactory(new PropertyValueFactory<Table, Integer>("TPR"));

        // заполняем таблицу данными
        tableUsers.setItems(usersData);
    }

    @FXML
    private TextField tip;
    @FXML
    private TextField tio;
    @FXML
    private TextField tio2;
    @FXML
    private Label tos;
    @FXML
    private Label pp1c;
    @FXML
    private Label pp2c;

    public void btn(ActionEvent actionEvent) {
        initialize();
        tip2 = Integer.parseInt(tip.getText());
        tio3 = Integer.parseInt(tio.getText());
        tio4 = Integer.parseInt(tio2.getText());
        Random random = new Random();
        for (i = 1; i < 21; i++){
            k = 1;
            tip3 = random.nextInt(tip2);
            tp = tp + tip3;
            tio5 = random.nextInt(tio3);
            if (tp < too){
                to = to + too - tp;
                too = too + tio5;
                tpr = 0;
                tno = tp + to;
                tos1 += to;
                usersData.add(new Table(i, k, tip3, tio5, tp, tno, too, to, tpr));
            } else {
                tpr = tpr + tp - too;
                too = tp + tio5;
                to = 0;
                tno = tp + to;
                usersData.add(new Table(i, k, tip3, tio5, tp, tno, too, to, tpr));
            }
        }
        for (i = 21; i < 101; i++){
            k = 2;
            tip3 = random.nextInt(tip2);
            tp = tp + tip3;
            tio6 = random.nextInt(tio4);
            if (tp < too2){
                to = to + too2 - tp;
                too2 = too2 + tio6;
                tpr2 = 0;
                tno = tp + to;
                tos2 += to;
                usersData.add(new Table(i, k, tip3, tio5, tp, tno, too2, to, tpr2));
            } else {
                tpr2 = tpr + tp - too2;
                too2 = tp + tio6;
                to = 0;
                tno = tp + to;
                usersData.add(new Table(i, k, tip3, tio5, tp, tno, too2, to, tpr2));
            }
        }
        System.out.println((tos1+tos2)/100);
        tos.setText((tos1+tos2)/100+"");
        pp1c.setText(tpr/too+"%");
        pp2c.setText(tpr2/too2+"%");
    }
}
