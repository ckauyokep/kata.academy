import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		$calc("КАЛЬКУЛЯТОР.");

	}

	public static void $calc(String $input) {

		String[] $arabicNumbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		String[] $romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
		int $arabicCounter = 0;
		int[] $arabicOperands = new int[2];
		int $romanCounter = 0;
		int[] $romanOperands = new int[2];
		int $resultRoman = 0;

		Scanner $sc = new Scanner(System.in);
//		System.out.println("ВВЕДИТЕ ДВА ОПЕРАНДА от 1 до 10. НАПРИМЕР (2 + 2 или II + II).");
//		System.out.println("ПОДДЕРЖИВАЮТСЯ АРАБСКИЕ И РИМСКИЕ ЦИФРЫ.");
		String $scanner = $sc.nextLine();

		try {

			String[] $iDigits = $scanner.split("\\+|\\-|\\*|\\/");
			for (String $a : $iDigits) {
				$a = $a.trim();
				for (int $b = 0; $b < $romanNumbers.length; $b++) {
					if ($b < 10 && $a.equals($romanNumbers[$b])) {
//					System.out.println($a.trim());
//					System.out.println("РИМСКАЯ цифра. " + ($b + 1));
						$romanOperands[$romanCounter] = ++$b;
						$romanCounter++;
					} else if ($b < 10 && $a.equals($arabicNumbers[$b])) {
//					System.out.println($a.trim());
//					System.out.println("АРАБСКАЯ цифра. " + ($b + 1));
						$arabicOperands[$arabicCounter] = ++$b;
						$arabicCounter++;
					}
				}
			}
//			System.out.println("РИМСКИХ цифр: " + $romanCounter + " шт.");
			if ($arabicCounter == 2 && $iDigits.length == 2) { // ПРОВЕРКА НА ОДИНАКОВЫЕ ЦИФРЫ И ПРОВЕРКА НА НЕ БОЛЕЕ 2 ОПЕРАНДОВ РАЗНЫХ СИСТЕМ.
				if ($scanner.contains("+"))
					System.out.println("РЕЗУЛЬТАТ СЛОЖЕНИЯ: " + ($arabicOperands[0] + $arabicOperands[1]));
				if ($scanner.contains("-"))
					System.out.println("РЕЗУЛЬТАТ ВЫЧИТАНИЯ: " + ($arabicOperands[0] - $arabicOperands[1]));
				if ($scanner.contains("*"))
					System.out.println("РЕЗУЛЬТАТ УМНОЖЕНИЯ: " + ($arabicOperands[0] * $arabicOperands[1]));
				if ($scanner.contains("/"))
					System.out.println("РЕЗУЛЬТАТ ДЕЛЕНИЯ: " + ($arabicOperands[0] / $arabicOperands[1]));
			} else if ($romanCounter == 2 && $iDigits.length == 2) {
				if ($scanner.contains("+")) {
					$resultRoman = $romanOperands[0] + $romanOperands[1];
					if ($resultRoman > 0) {
						System.out.println("РЕЗУЛЬТАТ СЛОЖЕНИЯ: " + $romanNumbers[$resultRoman - 1]);
					} else throw new Exception("ОШИБКА СЛОЖЕНИЯ НЕВОЗМОЖНА.");
				}
				if ($scanner.contains("-")) {
					$resultRoman = $romanOperands[0] - $romanOperands[1];
					if ($resultRoman > 0) {
						System.out.println("РЕЗУЛЬТАТ ВЫЧИТАНИЯ: " + $romanNumbers[$resultRoman - 1]);
					} else throw new Exception("ОШИБКА ВЫЧИТАНИЯ. Результат операции с РИМСКИМИ числами меньше нуля.");
				}
				if ($scanner.contains("*")) {
					$resultRoman = $romanOperands[0] * $romanOperands[1];
					if ($resultRoman > 0) {
						System.out.println("РЕЗУЛЬТАТ УМНОЖЕНИЯ: " + $romanNumbers[$resultRoman - 1]);
					} else throw new Exception("ОШИБКА УМНОЖЕНИЯ. Результат операции с РИМСКИМИ числами меньше нуля.");
				}
				if ($scanner.contains("/")) {
					$resultRoman = $romanOperands[0] / $romanOperands[1];
					if ($resultRoman > 0) {
						System.out.println("РЕЗУЛЬТАТ ДЕЛЕНИЯ: " + $romanNumbers[$resultRoman - 1]);
					} else throw new Exception("ОШИБКА ДЕЛЕНИЯ. Результат операции с РИМСКИМИ числами меньше нуля.");
				}
			} else throw new Exception("Введены НЕПРАВИЛЬНЫЕ ОПЕРАНДЫ или их КОЛИЧЕСТВО.");

		} catch (Exception $exception) {
			System.out.println($exception);
//			System.out.println($exception.getMessage());
		}

	}
}
