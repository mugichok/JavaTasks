// Программист Василий работает в ИТ-компании. Он забыл пароль к своему рабочему ноутбуку и теперь боится, что попросту не успеет сделать порученные ему задачи.
// В компании действуют строгие требования к пароля на рабочие ноутбуки: для каждого сотрудника определен набор символов, только из которых должен состоять пароль, причём каждый символ из набора должен встречаться хотя бы один раз. Василий помнит этот набор. Также Василий помнит, что длина его пароля не превосходит kk символов.
// С помощью небольших усилий ему удалось восстановить, какие клавиши он нажимал на клавиатуре за последнее время. Теперь у него в распоряжении есть последовательность символов, в которой может оказаться его пароль. Помогите Василию восстановить свой пароль или определите, что восстановить его уже невозможно!
// Формат входных данных
// В первой строке ввода дана последовательность длины nn (1≤n≤2×10^5)(1≤n≤2×10^5) из строчных латинских букв — последовательность символов, которые нажимал Василий за последнее время.
// Во второй строке дан набор символов — требования к паролю, а в третьей — число kk (1≤k≤2×10^5)(1≤k≤2×10^5), максимальная длина пароля.
// Формат выходных данных
// Выведите возможный пароль от ноутбука, удовлетворяющий указанным условиям. Если вариантов пароля несколько, выберите тот, который начинается в последовательности из первой строки правее (позже) других, а среди всех с одинаковым с ним началом — самый длинный.
// Если восстановить пароль не удастся, выведите «−1» (без кавычек).


package Others;
import java.util.Scanner;

public class GuessPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sequence = scanner.nextLine();
        String requirements = scanner.nextLine();
        int k = scanner.nextInt();
        guessPassword(sequence, requirements, k);
        scanner.close();

    }

    public static void guessPassword(String sequence, String requirements, int k){
        String password = new String();
        String password1 = new String();
        String[] seqArr = sequence.split("");
        String[] reqArr = requirements.split("");

        for(int i = 0; i < sequence.length()-k+1; i++){
            password = sequence.substring(i, i + k);
            if(checkSequence(seqArr, requirements, i, k) && checkSequence(reqArr, password, 0, reqArr.length)){
                password1 = password;
            }
        }

        if(password1.length() > 0){
            System.out.println(password1);
        } else {
            System.out.println(-1);
        }
    }

    public static boolean checkSequence(String[] seq, String req, int i, int k){
        if(k <= 1){
            return true;
        }
        if(req.contains(seq[i+k-1])){
            return checkSequence(seq, req, i, --k);
        } else{
            return false;
        }
    }
}
