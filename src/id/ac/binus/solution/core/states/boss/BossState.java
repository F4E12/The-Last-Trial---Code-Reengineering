package id.ac.binus.solution.core.states.boss;

import game.core.interfaces.CharacterContext;

public interface BossState {
  void start(CharacterContext context);
  void update(CharacterContext context);
  void exit(CharacterContext context);
}