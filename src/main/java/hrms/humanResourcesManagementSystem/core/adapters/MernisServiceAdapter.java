package hrms.humanResourcesManagementSystem.core.adapters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.springframework.stereotype.Component;

import hrms.humanResourcesManagementSystem.business.abstracts.UserValidationService;
import hrms.humanResourcesManagementSystem.core.utilities.results.ErrorResult;
import hrms.humanResourcesManagementSystem.core.utilities.results.Result;
import hrms.humanResourcesManagementSystem.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.ws.KPSPublic;
import tr.gov.nvi.tckimlik.ws.KPSPublicSoap;


@Component("MernisV")
public class MernisServiceAdapter implements UserValidationService<JobSeeker>{

	@Override
	public Result validate(JobSeeker jobSeeker) {
		
		
		String endpoint = "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx";
		
		URL url = null;
		
		try {
			url = URI.create(endpoint).toURL();
		} catch (MalformedURLException e) {
			return new ErrorResult();
		}
		
		KPSPublic service = new KPSPublic(url);
		KPSPublicSoap port = service.getPort(KPSPublicSoap.class);
		
		
		/*
		 * String stringSayi = "53532423"; 
		 * long sayi1 = Long.valueOf(stringSayi); 
		 * long sayi2 = Long.parseLong(stringSayi);
		*/
		
		
		long nationalIdNoL = Long.parseLong(jobSeeker.getNationalIdNo());
		
		
		
		return new Result(port.tcKimlikNoDogrula(nationalIdNoL, jobSeeker.getFirstName().toUpperCase(), 
				jobSeeker.getLastName().toUpperCase(), jobSeeker.getBirthDate().getYear()));
	}
	
	
}
