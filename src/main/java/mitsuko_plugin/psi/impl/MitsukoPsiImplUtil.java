package mitsuko_plugin.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import mitsuko_plugin.psi.MitsukoElementFactory;
import mitsuko_plugin.psi.MitsukoFnDefine;
import mitsuko_plugin.psi.MitsukoFunction;
import mitsuko_plugin.psi.MitsukoTypes;

public class MitsukoPsiImplUtil {
    public static String getFunctionName(MitsukoFnDefine element) {
        ASTNode keyNode = element.getNode().findChildByType(MitsukoTypes.FN_NAME);
        if (keyNode != null) {
            return keyNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(MitsukoFnDefine element) {
        return getFunctionName(element);
    }

    public static PsiElement setName(MitsukoFnDefine element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(MitsukoTypes.FN_NAME);
        if (keyNode != null) {
            MitsukoFnDefine function =
                    MitsukoElementFactory.createFunction(element.getProject(), newName);
            ASTNode newKeyNode = function.getChildren()[1].getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(MitsukoFnDefine element) {
        ASTNode keyNode = element.getNode().findChildByType(MitsukoTypes.FN_NAME);
        return keyNode != null ? keyNode.getPsi() : null;
    }
}
