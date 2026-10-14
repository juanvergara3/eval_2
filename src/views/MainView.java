package views;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

public class MainView extends JFrame {
    // variables globales
    private JPanel pnlAddShipment;
    private JButton btnRemoveShipment,btnSaveShipment;
    private JTable tblShipments;

    // campos de la vista que el controlador necesita
    private JTextField txtShipmentCode, txtCustomerName, txtDistance, txtWeight;
    private JComboBox<String> cmbShipmentType;

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

        // botón es público para que el controlador pueda agregarle un actionListener
        btnRemoveShipment = new JButton();
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
        JLabel lblShipmentNumber = new JLabel("Código");
        lblShipmentNumber.setBounds(10, 10, 100, 25);
        pnlAddShipment.add(lblShipmentNumber);

        txtShipmentCode = new JTextField();
        txtShipmentCode.setBounds(120, 10, 100, 25);
        pnlAddShipment.add(txtShipmentCode);
        
        JLabel lblShipmentType = new JLabel("Tipo");
        lblShipmentType.setBounds(240, 10, 100, 25);
        pnlAddShipment.add(lblShipmentType);

        cmbShipmentType = new JComboBox<String>();
        cmbShipmentType.setBounds(350, 10, 100, 25);
        pnlAddShipment.add(cmbShipmentType);

        // campos de la fila 2
        JLabel lblCustomerName = new JLabel("Cliente");
        lblCustomerName.setBounds(10, 50, 100, 25);
        pnlAddShipment.add(lblCustomerName);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(120, 50, 100, 25);
        pnlAddShipment.add(txtCustomerName);

        JLabel lblDistance = new JLabel("Distancia (Km)");
        lblDistance.setBounds(240, 50, 100, 25);
        pnlAddShipment.add(lblDistance);

        txtDistance = new JTextField();
        txtDistance.setBounds(350, 50, 100, 25);
        pnlAddShipment.add(txtDistance);

        // elementos de la fila 3
        JLabel lblWeight = new JLabel("Peso (Kg)");
        lblWeight.setBounds(10, 90, 100, 25);
        pnlAddShipment.add(lblWeight);

        txtWeight = new JTextField();
        txtWeight.setBounds(120, 90, 100, 25);
        pnlAddShipment.add(txtWeight);

        // boton es público para que el controlador pueda agregarle un actionListener
        btnSaveShipment = new JButton("Guardar");
        btnSaveShipment.setBounds(240, 90, 100, 25);
        pnlAddShipment.add(btnSaveShipment);

        JButton btnCancelShipment = new JButton("Cancelar");
        btnCancelShipment.setBounds(350, 90, 100, 25);
        pnlAddShipment.add(btnCancelShipment);

        // 2. panel de vista de envíos
        // siempre visible, muestra la lista de envíos agregados
        // se hace global para que el controlador pueda manipularlo
        tblShipments = new JTable();
        JScrollPane spShipmentList = new JScrollPane(tblShipments);

        // añadir páneles al panel principal
        pnlMain.add(pnlAddShipment);
        pnlMain.add(spShipmentList);
        add(pnlMain, BorderLayout.CENTER);

        // Escuchadores de eventos de interfaz (nada que ver con el controlador, solo manipula la interfaz)
        btnAddShipment.addActionListener(e -> {
            btnAddShipmentClicked();
        });

        btnCancelShipment.addActionListener(e -> {
            btnCancelShipmentClicked();
        });
    }

    // métodos privados exclusivos de interfaz gráfica
    // es decir, solo se encargan de manipular la interfaz, no tienen nada de lógica
    private void btnAddShipmentClicked() {
        pnlAddShipment.setVisible(true);
    }

    private void btnCancelShipmentClicked() {
        clearShipmentFields();
        hideShipmentEdit();
    }

    // métodos públicos para que el controlador pueda manipular la vista
    public void populateShipmentTypeComboBox(String[] shipmentTypes) {
        for (String type : shipmentTypes) {
            cmbShipmentType.addItem(type);
        }
    }

    public void showShipments(String [] headers, String[][] data) {
        DefaultTableModel model = new DefaultTableModel(data, headers);
        tblShipments.setModel(model);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void clearShipmentFields() {
        txtShipmentCode.setText("");
        txtCustomerName.setText("");
        txtDistance.setText("");
        txtWeight.setText("");
        cmbShipmentType.setSelectedIndex(0);
    }

    public void hideShipmentEdit() {
        pnlAddShipment.setVisible(false);
    }

    public boolean confirm(String message) {
        if (JOptionPane.showConfirmDialog(this, message, "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }

    public String askForInput(String message) {
        return JOptionPane.showInputDialog(this, message);
    }

    // setters para inyección de dependencias
    public void setAddShipmentClick(ActionListener listener) {
        btnSaveShipment.addActionListener(listener);
    }

    public void setRemoveShipmentClick(ActionListener listener) {
        btnRemoveShipment.addActionListener(listener);
    }

    // getter públicos para que el controlador pueda obtener los datos de la vista
    public String getCustomer() {
        return txtCustomerName.getText();
    }

    public String getCode() {
        return txtShipmentCode.getText();
    }

    public String getWeight() {
        return txtWeight.getText();
    }

    public String getDistance() {
        return txtDistance.getText();
    }

    public String getShipmentType() {
        return (String) cmbShipmentType.getSelectedItem();
    }

    public int getSelectedShipmentIndex() {
        return tblShipments.getSelectedRow();
    }
}
