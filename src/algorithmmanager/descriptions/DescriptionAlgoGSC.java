package algorithmmanager.descriptions;

import java.io.IOException;

import algorithmmanager.DescriptionOfAlgorithm;
import algorithmmanager.DescriptionOfParameter;
//import ca.pfv.spmf.algorithms.frequentpatterns.apriori.AlgoApriori;
/* This file is copyright (c) 2008-2016 Philippe Fournier-Viger
* 
* This file is part of the SPMF DATA MINING SOFTWARE
* (http://www.philippe-fournier-viger.com/spmf).
* 
* SPMF is free software: you can redistribute it and/or modify it under the
* terms of the GNU General Public License as published by the Free Software
* Foundation, either version 3 of the License, or (at your option) any later
* version.
* 
* SPMF is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
* A PARTICULAR PURPOSE. See the GNU General Public License for more details.
* You should have received a copy of the GNU General Public License along with
* SPMF. If not, see <http://www.gnu.org/licenses/>.
*/

/**
 * This class describes the Apriori algorithm parameters. 
 * It is designed to be used by the graphical and command line interface.
 * 
 * @see AlgoApriori
 * @author Philippe Fournier-Viger
 */
public class DescriptionAlgoGSC extends DescriptionOfAlgorithm {

	/**
	 * Default constructor
	 */
	public DescriptionAlgoGSC(){
		
	}

	@Override
	public String getName() {
		return "GSC";
	}

	@Override
	public String getAlgorithmCategory() {
		return "K-Anonymity";
	}

	@Override
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	public String getURLOfDocumentation() {
		return "http://www.ikelab.net/ppmf/";
	}

	@Override
	public void runAlgorithm(String[] parameters, String inputDatabaseFile, String outputFile) throws IOException {

	}
	
	@Override
	public void runPPMFAlgorithm(String[] parameters, String inputDatabaseFile, String inputSensitiveFile, String outputFile) throws IOException {
		int ks = getParamAsInteger(parameters[0]);

		algorithms.KAnonymity.GSC.AlgoGSC algorithm = new algorithms.KAnonymity.GSC.AlgoGSC ();
		int alpha = getParamAsInteger(parameters[1]);

		algorithm.runPPMFAlgorithm(ks, alpha, inputDatabaseFile, inputSensitiveFile, outputFile);
		
		algorithm.printStats();
	}

	@Override
	public DescriptionOfParameter[] getParametersDescription() {
        
		DescriptionOfParameter[] parameters = new DescriptionOfParameter[2];
		parameters[0] = new DescriptionOfParameter("Degree of anonymity", "(e.g. 5 or 10)", Integer.class, false);
		parameters[1] = new DescriptionOfParameter("Alpha", "(e.g. 2)", Integer.class, false);
		return parameters;
	}

	@Override
	public String getImplementationAuthorNames() {
		return "Philippe Fournier-Viger";
	}

	@Override
	public String[] getInputFileTypes() {
		return new String[]{"Database of instances","Transaction database", "Simple transaction database"};
	}

	@Override
	public String[] getOutputFileTypes() {
		return new String[]{"Patterns", "Frequent patterns", "Frequent itemsets"};
	}
	
}

