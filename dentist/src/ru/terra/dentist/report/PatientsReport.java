package ru.terra.dentist.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import ru.terra.dentist.orm.PatientManager;
import ru.terra.dentist.orm.dto.PatientListDTO;
import ru.terra.dentist.orm.entity.Patient;

/**
 *
 * @author terranz
 */
public class PatientsReport
{

    public PatientsReport()
    {
    }

    public String allPatientsReport()
    {
        FileOutputStream stream = null;
        try
        {
            stream = new FileOutputStream("outputFile.xml");
            JAXBContext context = JAXBContext.newInstance(PatientListDTO.class);
            Marshaller marshaller = context.createMarshaller();
            PatientManager pm = new PatientManager();
            PatientListDTO pl = new PatientListDTO(pm.findAllPatients());
            marshaller.marshal(pl, stream);
        }
        catch (JAXBException ex)
        {
            Logger.getLogger(PatientsReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(PatientsReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                stream.close();
            }
            catch (IOException ex)
            {
                Logger.getLogger(PatientsReport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }
}
