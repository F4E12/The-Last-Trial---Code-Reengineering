package id.ac.binus.solutionOOP.core.states.boss;

import id.ac.binus.solutionOOP.core.interfaces.CharacterContext;

public interface BossState {
  void start(CharacterContext context);
  void update(CharacterContext context);
}