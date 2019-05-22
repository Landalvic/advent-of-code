export const part1 = input => {
  return input
    .split("\n")
    .map(a => parseInt(a, 10))
    .reduce((a, b) => a + b);
};

export const part2 = input => {
  const liste = input.split("\n").map(a => parseInt(a, 10));
  const frequencesDejaVues = {};
  let calcul = 0;
  for (;;) {
    for (let i = 0; i < liste.length; i += 1) {
      calcul += liste[i];
      if (frequencesDejaVues[calcul]) {
        return calcul;
      }
      frequencesDejaVues[calcul] = true;
    }
  }
};
