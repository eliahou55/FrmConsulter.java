package Vues;

import Controlers.*;
import Tools.ConnexionBDD;
import Tools.ModelJTable;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;


public class FrmPrescrire extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumero;
    private JLabel lblDate;
    private JLabel lblNomMedecin;
    private JTextField txtNumeroConsultation;
    private JComboBox<String> cboPatients;
    private JComboBox<String> cboMedecins;
    private JButton btnInserer;
    private JTable tblMedicaments;
    private JPanel pnlDate;
    private JLabel lblNomPatient;
    private JLabel lblMedicaments;
    private JDateChooser dcDateConsultation;

    CtrlConsultation ctrlConsultation;
    CtrlMedecin ctrlMedecin;
    CtrlPatient ctrlPatient;
    CtrlMedicament ctrlMedicament;
    CtrlPrescrire ctrlPrescrire;
    ModelJTable mdl;
    public FrmPrescrire() throws SQLException, ClassNotFoundException {
        this.setTitle("Prescrire");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ConnexionBDD maCnx = new ConnexionBDD();


        // Gestion de la date : ne pas supprimer les 3 lignes de code
        dcDateConsultation = new JDateChooser();
        dcDateConsultation.setDateFormatString("yyyy-MM-dd");
        pnlDate.add(dcDateConsultation);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);

                mdl= new ModelJTable();
                ctrlMedicament = new CtrlMedicament();
                try {mdl.loadDatasMedicaments(ctrlMedicament.getAllMedicaments());
                    tblMedicaments.setModel(mdl);
                }catch (SQLException ex )
                {
                    throw new RuntimeException(ex);
                }



                /*for (String nomdupatient : ctrlPatient.getAllPatients())
                {
                    cboPatients.addItem(nomdupatient);
                }*/
                CtrlPatient ctrlPatient = new CtrlPatient() ;


                //JComboBox<String> cboPatients = new JComboBox<>();
                for (String nomdupatient:ctrlPatient.getAllPatients())
                    cboPatients.addItem(nomdupatient);

                CtrlMedecin ctrlMedecin = new CtrlMedecin() ;

                for (String nomdumedecin:ctrlMedecin.getAllMedecins())
                    cboMedecins.addItem(nomdumedecin);

            }
        });

        btnInserer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // A vous de jouer

            }
        });
    }
}
