package Vue;


import Control.ModeleVueCtrl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LisnnerCntrl implements ActionListener {

    private CaseGraphique caseGraphique;

    LisnnerCntrl(CaseGraphique caseGraphique) {
        this.caseGraphique = caseGraphique;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ModeleVueCtrl.getInstance().deleteIfCan(caseGraphique.getGridPosX(), caseGraphique.getGridPosY());
    }
}
