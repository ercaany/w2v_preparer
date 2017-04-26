package command;

import application.GlobalParameter;

/**
 * Created by ercan on 26.04.2017.
 */
public class SetCommand implements Command {
    public boolean execute(String[] parameter) {
        if(GlobalParameter.parameterMap.get(parameter[1]) == null) {
            if(GlobalParameter.filenameMap.get(parameter[1]) == null){
                System.out.println(parameter[1] + " isimli parametre yok");
            } else {
                String newFilename = parameter[2];
                GlobalParameter.filenameMap.put(parameter[1], newFilename);
            }
        } else {
            try {
                int value = Integer.parseInt(parameter[2]);
                GlobalParameter.parameterMap.put(parameter[1], value);
            } catch (NumberFormatException ex) {
                System.out.println("Lütfen sayısal bir değer giriniz.");
                ex.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
