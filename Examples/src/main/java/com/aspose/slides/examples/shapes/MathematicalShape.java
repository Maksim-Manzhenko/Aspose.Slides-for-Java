package com.aspose.slides.examples.shapes;

import com.aspose.slides.*;
import com.aspose.slides.examples.RunExamples;


public class MathematicalShape
{
    public static void main(String[] args)
    {
        //Path for output presentation
        String outPptxFile = RunExamples.getOutPath() + "MathematicalShape_out.pptx";

        //ExStart:MathematicalShape
        Presentation pres = new Presentation();
        try
        {
            // Create a new AutoShape of the type Rectangle to host mathematical content inside and adds it to the end of the collection.
            IAutoShape mathShape = pres.getSlides().get_Item(0).getShapes().addMathShape(10, 10, 100, 25);

            // Cteate mathematical paragraph that is a container for mathematical blocks.
            IMathParagraph mathParagraph = ((MathPortion) mathShape.getTextFrame().getParagraphs().get_Item(0).getPortions().get_Item(0)).getMathParagraph();

            // Create mathematical expression as an instance of mathematical text that contained within a MathParagraph.
            IMathBlock mathBlock = new MathematicalText("c")
                    .setSuperscript("2")
                    .join("=")
                    .join(new MathematicalText("a")
                            .setSuperscript("2"))
                    .join("+")
                    .join(new MathematicalText("b")
                            .setSuperscript("2"));

            // Add mathematical expression to the mathematical paragraph.
            mathParagraph.add(mathBlock);

            pres.save(outPptxFile, SaveFormat.Pptx);
        }
        finally
        {
            if (pres != null) pres.dispose();
        }
        //ExEnd:MathematicalShape
    }
}

