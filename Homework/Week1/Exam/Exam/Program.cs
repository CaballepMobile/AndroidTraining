using System;
using System.Collections.Generic;
using System.Linq;

namespace Exam
{
    class Program
    {
        static void Main(string[] args)
        {
            //First
            Console.WriteLine(F("ABCDE"));

            //Second
            List<char> chars = new List<char>() { 'A', 'B', 'C', 'A', 'B', 'A', 'H', 'X' };
            List<Utilities.ValueCount> valueCountList = G(chars);
            foreach (var item in valueCountList)
            {
                Console.WriteLine(item.Value + " - " +item.Count);
            }

            Console.Read();
        }

        public static string F(string text)
        {
            string encodedWord = "";
            for (int i = 0; i < text.Length; i++)
            {
                encodedWord += Utilities.ReturnOppositeLetter(text[i]);
            }

            return encodedWord;
        }

        public static List<Utilities.ValueCount> G(List<char> chars)
        {
            return chars.GroupBy(x => x).Select(x => new Utilities.ValueCount() { Value = x.Key, Count = (byte)x.Count() }).ToList();
        }
    }

    public static class Utilities
    {
        private static string _alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        public static char ReturnOppositeLetter(char letter)
        {
            char oppositeLetter = ' ';
            for (int i = 0; i < _alphabet.Length; i++)
            {
                if (letter.Equals(_alphabet[i]))
                {
                    oppositeLetter = _alphabet[_alphabet.Length - i - 1];
                    break;
                }
            }

            return oppositeLetter;
        }

        public struct ValueCount
        {
            public char Value;
            public byte Count;
        }
    }
}