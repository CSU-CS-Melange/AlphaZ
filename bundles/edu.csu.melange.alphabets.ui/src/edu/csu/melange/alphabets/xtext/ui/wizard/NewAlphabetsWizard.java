package edu.csu.melange.alphabets.xtext.ui.wizard;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;

public class NewAlphabetsWizard extends Wizard implements INewWizard {
	

    private WizardNewFileCreationPage mainPage;

    private IWorkbench workbench;
    private IStructuredSelection selection;
    
    public void init(IWorkbench workbench, IStructuredSelection selection) {
    	this.workbench = workbench;
    	this.selection = selection;
    }
    
    /**
     * Returns the selection which was passed to <code>init</code>.
     *
     * @return the selection
     */
    public IStructuredSelection getSelection() {
        return selection;
    }

    /**
     * Returns the workbench which was passed to <code>init</code>.
     *
     * @return the workbench
     */
    public IWorkbench getWorkbench() {
        return workbench;
    }

	@Override
	public void addPages() {
		super.addPages();
        mainPage = new WizardNewFileCreationPage("newFilePage1", getSelection());//$NON-NLS-1$
        mainPage.setTitle("New Alphabets");
        mainPage.setDescription("Create new Alphabets");
        mainPage.setFileExtension("ab");
        mainPage.setFileName("newSystem.ab");
        addPage(mainPage);
	}

	@Override
	public boolean performFinish() {
        IFile file = mainPage.createNewFile();
        if (file == null) {
			return false;
		}
        
        BufferedWriter bw = null;
        try {
        	bw = new BufferedWriter(new FileWriter(file.getRawLocation().toFile()));
        	bw.write(String.format("affine %s {|}\n", mainPage.getFileName().replaceAll("\\."+mainPage.getFileExtension()+"$", "")));
        	bw.write("input\n\t//inputs\n");
        	bw.write("output\n\t//outputs\n");
        	bw.write("local\n\t//locals\n");
        	bw.write("let\n\t//equations\n");
        	bw.write(".\n");
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (bw != null)
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
        //bos.w

        // Open editor on new file.
        IWorkbenchWindow dw = getWorkbench().getActiveWorkbenchWindow();
        try {
            if (dw != null) {
                IWorkbenchPage page = dw.getActivePage();
                if (page != null) {
                    IDE.openEditor(page, file, true);
                }
            }
        } catch (PartInitException e) {
        	e.printStackTrace();
        }

        return true;
	}

	
	

}
