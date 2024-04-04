module org.iespoblenou.m07_uf1_javafx_joelvinansaca {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens org.iespoblenou.m07_uf1_javafx_joelvinansaca to javafx.fxml;
    exports org.iespoblenou.m07_uf1_javafx_joelvinansaca;
}