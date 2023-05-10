package Controlers;

import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> getAllMedicaments() throws SQLException {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();

        ps = cnx.prepareStatement("SELECT medicament.idMedoc, medicament.nomMedoc, medicament.prixMedoc, MAX(prescrire.quantite =0) as quantite\n" +
                "FROM medicament\n" +
                "LEFT JOIN prescrire ON prescrire.numMedoc = medicament.idMedoc\n" +
                "GROUP BY medicament.idMedoc, medicament.nomMedoc, medicament.prixMedoc;");
        rs =ps.executeQuery();
        while (rs.next())
        {
            Medicament unMedicament = new Medicament (rs.getInt(1), rs.getString(2),rs.getDouble(3),rs.getInt(4));
            lesMedicaments.add(unMedicament);
        }

        // A vous de jouer

        return lesMedicaments;
    }
}
