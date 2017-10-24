# coding: utf-8
# Elementos duplicados

seq = map(int, raw_input().split())

def verifica_elementos_duplicados(seq):
  for i in xrange(len(seq)):
    for j in xrange(i + 1, len(seq)):
      if seq[i] == seq[j]:
        return "true"
  return "false"

print verifica_elementos_duplicados(seq)