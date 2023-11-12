package blog.howardli.java_external_study.java_ast;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"blog.howardli.java_external_study.java_ast.Check"})
public class CheckProcessor  extends AbstractProcessor {
    /**
     *  如果在 process 中修改了語法樹，編譯器就會回到上一步重新處理，然後再次執行 process，
     *  每次執行 process 稱為一個 round，可以透過 RoundEnvironment 來取得語法樹元素資訊，
     *  例如 getRootElements 取得了前一個 round 時處理的根元素（在這邊就是類別），
     *  這個循環會進行到語法樹沒有任何修改，然後進入 last round， 可以透過 processingOver
     *  來得知是否 last round。
     *
     *  通常建議將標註處理器用於原始碼檢查、程式碼產生器，這就需要知道原始碼的資訊，在編譯時期，
     *  javac 本身會運行在一個 JVM，這也是為何你可以如上使用 Java 程式碼來運用 Processor
     *  的原因，而原始碼資訊，主要會運用 javax.lang.model.type、javax.lang.model.element
     *  中的相關 API 來封裝（而不是透過 Reflection API，因為 Reflection API 只能用在執行時期）。
     *
     * @param annotations the annotation types requested to be processed
     * @param roundEnv  environment for information about the current and prior round
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println(roundEnv.processingOver());
        System.out.println(roundEnv.getRootElements());
        System.out.println(annotations);
        return false;
    }
}
