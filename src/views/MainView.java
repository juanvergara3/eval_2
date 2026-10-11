package views;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class MainView extends JFrame {
    // variables globales
    JPanel pnlAddShipment = new JPanel();

    public MainView() {
        setSize(600, 400);
        setTitle("Operador logístico");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JToolBar toolbar = new JToolBar();
        add(toolbar, BorderLayout.NORTH);

        JButton btnAddShipment = new JButton();
        btnAddShipment.setIcon(new ImageIcon(getClass().getResource("/icons/AddShipment.png")));
        btnAddShipment.setToolTipText("Agregar Envío");
        toolbar.add(btnAddShipment);

        JButton btnRemoveShipment = new JButton();
        btnRemoveShipment.setIcon(new ImageIcon(getClass().getResource("/icons/RemoveShipment.png")));
        btnRemoveShipment.setToolTipText("Eliminar Envío");
        toolbar.add(btnRemoveShipment);

        JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));

        // 1. panel para agregar un envíos
        // viene oculto por defecto, se mostrará al hacer click en el botón de agregar envío
        pnlAddShipment = new JPanel();
        pnlAddShipment.setPreferredSize(new Dimension(600, 300));
        pnlAddShipment.setLayout(null);
        pnlAddShipment.setVisible(false);

        // campos de la fila 1
        JLabel lblShipmentNumber = new JLabel("Número");
        lblShipmentNumber.setBounds(10, 10, 100, 25);
        pnlAddShipment.add(lblShipmentNumber);

        JTextField txtShipmentNumber = new JTextField();
        txtShipmentNumber.setBounds(120, 10, 100, 25);
        pnlAddShipment.add(txtShipmentNumber);
        
        JLabel lblShipmentType = new JLabel("Tipo");
        lblShipmentType.setBounds(240, 10, 100, 25);
        pnlAddShipment.add(lblShipmentType);

        JComboBox<String> cmbShipmentType = new JComboBox<>(new String[] {"Aéreo", "Marítimo", "Terrestre"}); // TODO esto es temporal
        cmbShipmentType.setBounds(350, 10, 100, 25);
        pnlAddShipment.add(cmbShipmentType);

        // campos de la fila 2
        JLabel lblCustomerName = new JLabel("Cliente");
        lblCustomerName.setBounds(10, 50, 100, 25);
        pnlAddShipment.add(lblCustomerName);

        JTextField txtCustomerName = new JTextField();
        txtCustomerName.setBounds(120, 50, 100, 25);
        pnlAddShipment.add(txtCustomerName);

        JLabel lblDistance = new JLabel("Distancia (Km)");
        lblDistance.setBounds(240, 50, 100, 25);
        pnlAddShipment.add(lblDistance);

        JTextField txtDistance = new JTextField();
        txtDistance.setBounds(350, 50, 100, 25);
        pnlAddShipment.add(txtDistance);

        // elementos de la fila 3
        JLabel lblWeight = new JLabel("Peso (Kg)");
        lblWeight.setBounds(10, 90, 100, 25);
        pnlAddShipment.add(lblWeight);

        JTextField txtWeight = new JTextField();
        txtWeight.setBounds(120, 90, 100, 25);
        pnlAddShipment.add(txtWeight);

        JButton btnSaveShipment = new JButton("Guardar");
        btnSaveShipment.setBounds(240, 90, 100, 25);
        pnlAddShipment.add(btnSaveShipment);

        JButton btnCancelShipment = new JButton("Cancelar");
        btnCancelShipment.setBounds(350, 90, 100, 25);
        pnlAddShipment.add(btnCancelShipment);

        // 2. panel de vista de envíos
        // siempre visible, muestra la lista de envíos agregados
        JTable tblShipments = new JTable();
        JScrollPane spShipmentList = new JScrollPane(tblShipments);

        // añadir páneles al panel principal
        pnlMain.add(pnlAddShipment);
        pnlMain.add(spShipmentList);
        add(pnlMain, BorderLayout.CENTER);

        // ---------------EVENT LISTENERS-----------------
        btnAddShipment.addActionListener(e -> {
            btnAddShipmentClicked();
        });

        btnRemoveShipment.addActionListener(e -> {
            // TODO implementar
        });

        btnSaveShipment.addActionListener(e -> {
            // TODO implementar
        });

        btnCancelShipment.addActionListener(e -> {
            btnCancelShipmentClicked();
        });
    }

    private void btnAddShipmentClicked() {
        pnlAddShipment.setVisible(true);
    }

    private void btnCancelShipmentClicked() {
        pnlAddShipment.setVisible(false);
    }
}
