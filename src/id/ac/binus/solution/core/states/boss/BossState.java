package id.ac.binus.solution.core.states.boss;

import id.ac.binus.solution.core.interfaces.CharacterContext;
/*
 * Smell Code : Dead Code
 * Reason     : Method exit tidak pernah dipakai dimanapun
 * Smell      : Delete Dead Code
 */

public interface BossState {
  void start(CharacterContext context);
  void update(CharacterContext context);
}