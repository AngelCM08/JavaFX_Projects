module com.example.tictacpuig {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictacpuig to javafx.fxml;
    exports com.example.tictacpuig;
}