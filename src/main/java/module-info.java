module com.example.tictacpuig {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.tictacpuig;
    opens com.example.tictacpuig to javafx.fxml;
}